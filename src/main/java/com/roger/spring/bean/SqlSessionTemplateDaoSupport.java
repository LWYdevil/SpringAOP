package com.roger.spring.bean;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * sqlSession基类
 */
public class SqlSessionTemplateDaoSupport {

	protected SqlSessionTemplate sqlSession;
	protected boolean externalSqlSession;
		
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSession = sqlSessionTemplate;
		this.externalSqlSession = true;
	}

	public final SqlSession getBatchSqlSession() {
		return new SqlSessionTemplate(this.sqlSession.getSqlSessionFactory(), ExecutorType.BATCH);
	}

	public SqlSession getSqlSession() {
		return this.sqlSession;
	}

	@Autowired(required = false)
	public final void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		if (!this.externalSqlSession) {
			this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
		}
	}
}
