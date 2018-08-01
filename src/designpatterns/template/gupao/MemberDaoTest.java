package designpatterns.template.gupao;


import designpatterns.template.gupao.dao.MemberDao;

/**
 * Created by Tom on 2018/3/11.
 */
public class MemberDaoTest {

    public static void main(String[] args) {

        MemberDao memberDao = new MemberDao();
        memberDao.query();

    }
}
