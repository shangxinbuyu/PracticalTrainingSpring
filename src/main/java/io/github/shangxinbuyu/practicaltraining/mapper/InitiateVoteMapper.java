package io.github.shangxinbuyu.practicaltraining.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.shangxinbuyu.practicaltraining.domin.po.Vote;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InitiateVoteMapper extends BaseMapper<Vote> {
}
