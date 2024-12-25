package io.github.shangxinbuyu.practicaltraining.service;

import io.github.shangxinbuyu.practicaltraining.domin.vo.VoteVO;

import java.util.List;

public interface InitiateVoteService {

    List<VoteVO> list();

    void change(VoteVO voteVO);
}
