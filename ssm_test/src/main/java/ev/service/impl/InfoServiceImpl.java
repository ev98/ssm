package ev.service.impl;

import ev.dao.InfoDao;
import ev.domain.Info;
import ev.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("infoService")
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoDao infoDao;

    @Override
    public Info login(Info info) {
        return infoDao.findInfoByUsernameAndPassword(info.getUsername(),info.getPassword());
    }
}
