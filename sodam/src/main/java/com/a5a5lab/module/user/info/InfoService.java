package com.a5a5lab.module.user.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
	@Autowired
	InfoDao infoDao;
}
