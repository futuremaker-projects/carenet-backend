package com.carenet.admin.code;

import java.util.List;

public interface CodeRepository {

    /** 관리자마다 코드가 전부 다르게 동작해야 할거 같다. */
    List<Code> findAllCodes(Long userId);

}
