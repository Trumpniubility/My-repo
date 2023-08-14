package com.cqupt.constant;

public class Constant {

    //供应商
    public static final String SUPPLIER="supplier";

    //类别
    public static final String SIMEQ_TYPE="simeqtype";

    //用户类型
    public static final String USER_TYPE="userType";

    public static final String USER_STUDENT="1";
    public static final String USER_TEACHER="2";
    public static final String USER_MANAGER="3";


    //请假状态
    public static final String LEAVE_DRAFT="草稿";
    public static final String LEAVE_UNAPPROVED="待审批";
    public static final String LEAVE_WITHDROW="撤回";
    public static final String LEAVE_PASS="通过";
    public static final String LEAVE_REJECT="拒批";

    //请假状态码
    public static final int LEAVE_DRAFT_NUM=1;
    public static final int LEAVE_UNAPPROVED_NUM=2;
    public static final int LEAVE_WITHDROW_NUM=3;
    public static final int LEAVE_PASS_NUM=4;
    public static final int LEAVE_REJECT_NUM=5;
}
