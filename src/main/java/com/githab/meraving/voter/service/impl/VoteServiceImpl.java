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
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.githab.meraving.voter.util.ValidationUtil.getFromOptional;

@AllArgsConstructor
@Service
public class VoteServiceImpl implements VoteService {
    private final VoteRepository repository;
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;

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
        if (LocalTime.now().isAfter(LocalTime.parse("11:00:00"))) {
            throw new TooLateException("It,s too late to change your mind!");
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
    public VoteDto getByMenu_DateAndUser(LocalDate date, Long id) {//по идее нужно проверять через getFromOptional, но как передать Optional? еще мне жутко не нравится этот поиск по дате, но умнее ниче не придумал пока
        User user = getFromOptional(userRepository.findById(id));
        return VoteDto.of(repository.getByMenu_DateAndUser(date, user));
    }

    @Override
    public VoteDto castVote(Long Menuid) {
        User user = null;//юзера, нам, по идее, отдаст Security?
        Vote vote = repository.getByMenu_DateAndUser(LocalDate.now(), null);
        if (vote == null) {
            vote = Vote.of(user, getFromOptional(menuRepository.findById(Menuid)));
            return VoteDto.of(repository.save(vote));
        } else if (LocalTime.now().isAfter(LocalTime.parse("11:00:00"))) {
            throw new TooLateException("It,s too late to change your mind!");
        } else {
            vote.setUser(user);
            vote.setMenu(getFromOptional(menuRepository.findById(Menuid)));
            return VoteDto.of(repository.save(vote));
        }
    }
}

