package im.lich.framework.application.modules.demo.dao.impl;

import im.lich.framework.application.modules.demo.dao.DemoDao;
import im.lich.framework.application.modules.demo.model.Demo;
import im.lich.framework.core.base.dao.BaseDAO;

import org.springframework.stereotype.Repository;

/**
 * @author ethan
 */
@Repository
public class DemoDaoImpl extends BaseDAO<Demo, Integer> implements DemoDao {
    
}
