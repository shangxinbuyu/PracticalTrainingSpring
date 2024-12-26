package io.github.shangxinbuyu.practicaltraining.controller;

import io.github.shangxinbuyu.practicaltraining.domin.Result;
import io.github.shangxinbuyu.practicaltraining.domin.vo.VoteVO;
import io.github.shangxinbuyu.practicaltraining.service.InitiateVoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/InitiateVote")
@RequiredArgsConstructor
public class InitiateVoteController {
    private final InitiateVoteService initiateVoteService;

    @GetMapping("/list")
    public Result<List<VoteVO>> list() {
        log.info("获取投票列表");
        return Result.success(initiateVoteService.list());
    }

    @GetMapping("/like")
    public Result<List<VoteVO>> like(@RequestParam String like) {
        log.info("模糊查询:{}", like);
        return Result.success(initiateVoteService.like(like));
    }

    @PostMapping("/change")
    public Result<String> changeVote(@RequestBody VoteVO voteVO) {
        log.info("修改投票信息:{}", voteVO);
        initiateVoteService.change(voteVO);
        return Result.success();
    }

    @GetMapping("/delete")
    public Result<String> delete(@RequestParam String id) {
        log.info("删除:{}", id);
        initiateVoteService.deleteById(id);
        return Result.success();
    }
}
