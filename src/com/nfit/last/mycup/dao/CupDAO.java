package com.nfit.last.mycup.dao;

import com.nfit.last.mycup.bean.Cup;
import com.nfit.last.mycup.utils.DBHelper;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class CupDAO {
    public List<Cup> listAll() throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select id, name, price, birth from cup";
        try {
            return new QueryRunner().query(
                    conn, sql, new BeanListHandler<Cup>(Cup.class));
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
    public void delete(String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from cup where id = ?";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
    public void deletes(String[] ids) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from cup where id in ?";
        try {
            new QueryRunner().update(conn, sql, ids);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
}
