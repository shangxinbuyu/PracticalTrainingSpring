package io.github.shangxinbuyu.practicaltraining.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.shangxinbuyu.practicaltraining.domin.po.Vote;
import io.github.shangxinbuyu.practicaltraining.domin.vo.VoteVO;
import io.github.shangxinbuyu.practicaltraining.mapper.InitiateVoteMapper;
import io.github.shangxinbuyu.practicaltraining.service.InitiateVoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InitiateVoteServiceImpl implements InitiateVoteService {

    private final InitiateVoteMapper initiateVoteMapper;

    @Override
    public List<VoteVO> list() {
        List<Vote> voteList = initiateVoteMapper.selectList(null);
        return ObjectCopy(voteList);
    }

    @Override
    public List<VoteVO> like(String like) {
        List<Vote> voteList = initiateVoteMapper.selectList(new LambdaQueryWrapper<Vote>()
                .like(Vote::getTitle, like));
        return ObjectCopy(voteList);
    }

    @Override
    public void change(VoteVO voteVO) {
        Vote vote = initiateVoteMapper.selectOne(new LambdaQueryWrapper<Vote>()
                .eq(Vote::getId, voteVO.getId()));
        if (vote != null) {
            vote.setState(voteVO.getState());
            vote.setTitle(voteVO.getTitle());
        }
        System.out.println(vote);
        initiateVoteMapper.updateById(vote);
    }


    private List<VoteVO> ObjectCopy(List<Vote> voteList) {
        List<VoteVO> voteVOList = new ArrayList<>();
        voteList.forEach(vote -> voteVOList.add(VoteVO.builder()
                .id(vote.getId())
                .publishTime(vote.getPublishTime())
                .title(vote.getTitle())
                .publishBy(vote.getPublishBy())
                .state(vote.getState())
                .build()));
        return voteVOList;
    }
}
