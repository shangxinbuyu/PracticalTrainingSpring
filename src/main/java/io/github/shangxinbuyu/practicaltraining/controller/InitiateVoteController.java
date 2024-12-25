package io.github.shangxinbuyu.practicaltraining.controller;

import io.github.shangxinbuyu.practicaltraining.domin.Result;
import io.github.shangxinbuyu.practicaltraining.domin.vo.VoteVO;
import io.github.shangxinbuyu.practicaltraining.service.InitiateVoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/InitiateVote")
@RequiredArgsConstructor
public class InitiateVoteController {
    private final InitiateVoteService initiateVoteService;

    @GetMapping("/list")
    public Result<List<VoteVO>> list() {
        return Result.success(initiateVoteService.list());
    }

    @GetMapping("/like")
    public Result<List<VoteVO>> like(@RequestParam String like) {
        return Result.success(initiateVoteService.like(like));
    }

    @PostMapping("/change")
    public Result<String> changeVote(@RequestBody VoteVO voteVO) {
        initiateVoteService.change(voteVO);
        System.out.println(voteVO);
        return Result.success();
    }
}
