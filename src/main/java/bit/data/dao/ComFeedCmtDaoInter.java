package bit.data.dao;

import bit.data.dto.ComFeedCmtDto;

import java.util.List;

public interface ComFeedCmtDaoInter {

    public void insertFeedCmt(ComFeedCmtDto dto);
    public List<ComFeedCmtDto> selectFeedCmt(int fd_id);
}
