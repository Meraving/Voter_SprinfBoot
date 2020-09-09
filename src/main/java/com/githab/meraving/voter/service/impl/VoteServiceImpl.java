package com.githab.meraving.voter.service.impl;

import com.githab.meraving.voter.dto.CreateVoteDto;
import com.githab.meraving.voter.dto.UpdateVoteDto;
import com.githab.meraving.voter.dto.VoteDto;
import com.githab.meraving.voter.model.Menu;
import com.githab.meraving.voter.model.User;
import com.githab.meraving.voter.model.Vote;
import com.githab.meraving.voter.repository.MenuRepository;
import com.githab.meraving.voter.repository.UserRepository;
import com.githab.meraving.voter.repository.VoteRepository;
import com.githab.meraving.voter.service.VoteService;
import com.githab.meraving.voter.util.exception.TooLateException;
import com.githab.meraving.voter.util.exception.WrongDateException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.githab.meraving.voter.util.ValidationUtil.getFromOptional;

@AllArgsConstructor
@Service
public class VoteServiceImpl implements VoteService {
    private final VoteRepository repository;
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;
//    @Value("${value.borderTime}")
    private final String borderTime = "11:00:00";

    @Override
    public VoteDto create(CreateVoteDto createVoteDto) {
        Assert.notNull(createVoteDto, "vote must be not null");
        User user = getFromOptional(userRepository.findById(createVoteDto.getUserId()));
        Menu menu = getFromOptional(menuRepository.findById(createVoteDto.getMenuId()));
        Vote vote = Vote.of(user, menu);
        return VoteDto.of(repository.save(vote));
    }

    @Override
    public VoteDto get(Long id) {
        return VoteDto.of(getFromOptional(repository.findById(id)));
    }

    @Override
    public VoteDto update(Long id, UpdateVoteDto updateVoteDto) {
        Assert.notNull(updateVoteDto, "vote must not be null");
        if (LocalTime.now().isAfter(LocalTime.parse(borderTime))) {
            throw new TooLateException();
        }
        Vote vote = getFromOptional(repository.findById(id));
        User user = getFromOptional(userRepository.findById(updateVoteDto.getUserId()));
        Menu menu = getFromOptional(menuRepository.findById(updateVoteDto.getMenuId()));
        vote.setUser(user);
        vote.setMenu(menu);
        return VoteDto.of(repository.save(vote));

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<VoteDto> getAllByMenu(Long id) {
        Menu menu = getFromOptional(menuRepository.findById(id));
        return repository.getAllByMenu(menu).stream().map(VoteDto::of).collect(Collectors.toList());
    }

    @Override
    public VoteDto getByUserAndMenu_Date(Long id, LocalDate date) {
        User user = getFromOptional(userRepository.findById(id));
        return VoteDto.of(getFromOptional(repository.getByUserAndMenu_Date(user, date)));
    }

    @Override
    public VoteDto castVote(Long menuId,Long userId) {
        User user = getFromOptional(userRepository.findById(userId));//юзера, нам, по идее, отдаст Security?
        Vote vote = repository.getByUserAndMenu_Date(user, LocalDate.now()).orElse(null);
        Menu menu = getFromOptional(menuRepository.findById(menuId));
        if (!menu.getDate().equals(LocalDate.now())){
            throw new WrongDateException();
        }
        if (vote == null) {
            vote = Vote.of(user, menu);
            return VoteDto.of(repository.save(vote));
        } else if (LocalTime.now().isAfter(LocalTime.parse(borderTime))) {
            throw new TooLateException();
        } else {
            vote.setMenu(menu);
            return VoteDto.of(repository.save(vote));
        }
    }
}