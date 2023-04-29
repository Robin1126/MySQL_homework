package homework01;

import DButils.DButils;

import java.sql.*;

/*
    1、取得每个部门最高薪水的人员名称
        第一步：先获得每个部门的最高薪水 注意 select中只能是分组函数和分组的字段，其他的字段没有意义
        第二步：将上面的临时表t和emp表连接，连接条件是deptno相等，sal和maxsal相等

 */
public class Homework01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;

        // 1. 注册驱动，获取连接 使用DButils工具
        try {
            conn = DButils.getConnection();
            // 3 获取数据库操作对象
            String sql =
                    "select " +
                        "e.ename, e.deptno, t.maxsal " +
                    "from " +
                        "emp e " +
                    "join" +
                        " (select deptno, max(sal) maxsal from emp  group by deptno) t " +
                    "on " +
                        "e.deptno = t.deptno and e.sal = t.maxsal";

            ps = conn.createStatement();
            rs = ps.executeQuery(sql);
//            System.out.println("ename\t maxsal\t deptno");
            while (rs.next()) {
                System.out.println(rs.getString("ename") + ", " + rs.getString("maxsal") + ", " + rs.getString("deptno"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.close(rs, ps, conn);
        }
    }
}
