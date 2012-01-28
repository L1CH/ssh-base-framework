package im.lich.framework.application.modules.demo.service.impl;

import im.lich.framework.application.modules.demo.dao.DemoDao;
import im.lich.framework.application.modules.demo.model.Demo;
import im.lich.framework.application.modules.demo.service.DemoService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.ISearch;
import com.googlecode.genericdao.search.SearchResult;

/**
 * @author ethan
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class DemoServiceImpl implements DemoService {
	@Resource
	private DemoDao demoDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(Demo demo) {
		return demoDao.save(demo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(Demo[] demos) {
		return demoDao.save(demos);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Demo demo) {
		return demoDao.remove(demo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(Demo[] demos) {
		demoDao.remove(demos);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(Integer id) {
		return demoDao.removeById(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void removeByIds(String[] ids) {
		for(String id : ids) {
		    demoDao.removeById(Integer.parseInt(id));
		}
	}

	@Override
	public List<Demo> findAll() {
		return demoDao.findAll();
	}

	@Override
	public Demo findById(Integer id) {
		return demoDao.find(id);
	}

	@Override
	public Demo[] findByIds(Integer[] ids) {
		return demoDao.find(ids);
	}

	@Override
	public List<Demo> search(ISearch search) {
		return demoDao.search(search);
	}
	
	@Override
	public int count(ISearch search) {
		return demoDao.count(search);
	}
	
	@Override
	public SearchResult<Demo> searchAndCount(ISearch search) {
		return demoDao.searchAndCount(search);
	}
	
	@Override
	public Integer searchUnique(ISearch search) {
		return demoDao.searchUnique(search);
	}
	
	@Override
	public void flush() {
		demoDao.flush();
	}
}
