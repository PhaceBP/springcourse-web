package hu.ericsson.springcourse.dao.jdbc;

import java.io.Serializable;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import hu.ericsson.springcourse.dao.BaseDao;
import hu.ericsson.springcourse.model.BusinessObject;

public abstract class DefaultBaseDao<T extends BusinessObject, ID extends Serializable> 
extends JdbcDaoSupport implements BaseDao<T, ID> {
	

}
