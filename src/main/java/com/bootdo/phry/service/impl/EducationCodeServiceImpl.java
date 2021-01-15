package com.bootdo.phry.service.impl;

import com.bootdo.common.domain.Tree;
import com.bootdo.common.utils.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.phry.dao.EducationCodeDao;
import com.bootdo.phry.domain.EducationCodeDO;
import com.bootdo.phry.dto.EducationCodeDTO;
import com.bootdo.phry.service.EducationCodeService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class EducationCodeServiceImpl implements EducationCodeService {
	@Autowired
	private EducationCodeDao educationCodeDao;
	
	@Override
	public EducationCodeDTO get(Long educationCodeId){

		EducationCodeDO educationCodeDO = educationCodeDao.get(educationCodeId);
        if (educationCodeDO != null){
            return ConvertDomainUtils.convertObject(educationCodeDO,EducationCodeDTO.class);
        }
		return  new EducationCodeDTO();
	}
	
	@Override
	public List<EducationCodeDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(educationCodeDao.list(map),EducationCodeDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return educationCodeDao.count(map);
	}
	
	@Override
	public R save(EducationCodeDTO educationCode){
        int i = educationCodeDao.save(ConvertDomainUtils.convertObject(educationCode,EducationCodeDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(EducationCodeDTO educationCode){
        int i = educationCodeDao.update(ConvertDomainUtils.convertObject(educationCode,EducationCodeDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Long educationCodeId){
		return educationCodeDao.remove(educationCodeId);
	}
	
	@Override
	public int batchRemove(Long[] educationCodeIds){
		return educationCodeDao.batchRemove(educationCodeIds);
	}

	@Override
	public Tree<EducationCodeDTO> getTree() {
		List<Tree<EducationCodeDTO>> trees = new ArrayList<Tree<EducationCodeDTO>>();
		List<EducationCodeDO> educationCodeDTOS = educationCodeDao.list(new HashMap<String, Object>(16));
		for (EducationCodeDO educationCodeDTO : educationCodeDTOS) {
			Tree<EducationCodeDTO> tree = new Tree<EducationCodeDTO>();
			tree.setId(educationCodeDTO.getEducationCodeId().toString());
			tree.setParentId(educationCodeDTO.getParentId().toString());
			tree.setText(educationCodeDTO.getEducationCodeName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<EducationCodeDTO> t = BuildTree.build(trees);
		return t;
	}

}
