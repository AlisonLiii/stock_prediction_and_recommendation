package org.launchcode.stocks.service.impl;

import org.launchcode.stocks.dao.KODao;
import org.launchcode.stocks.dao.TLSADao;
import org.launchcode.stocks.models.domain.KO;
import org.launchcode.stocks.models.domain.TLSA;
import org.launchcode.stocks.service.StockHistoryService;
import org.launchcode.stocks.service.TLSAService;
import org.launchcode.stocks.util.Constant;
import org.launchcode.stocks.util.ExceptionSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Huiyan Xing
 * @Date 2021/12/16 - 18:04
 */
@Service
public class TLSAImpl implements TLSAService {
    @Resource
    private TLSADao tlsaDao;

    @Override
    public List<TLSA> getWeeklyHistoryData(List<String> dayList) {
        List<TLSA> tlsaList = tlsaDao.selectTLSAByWeek(dayList);
        if (tlsaList == null || tlsaList.size() == 0){
            throw new ExceptionSender(Constant.NO_HIS_DATA);
        }
        return tlsaList;
    }
}
