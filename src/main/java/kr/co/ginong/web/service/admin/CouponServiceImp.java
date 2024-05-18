package kr.co.ginong.web.service.admin;

import kr.co.ginong.web.entity.coupon.Coupon;
import kr.co.ginong.web.entity.coupon.CouponCategory;
import kr.co.ginong.web.repository.coupon.CouponCategoryRepository;
import kr.co.ginong.web.repository.coupon.CouponRepository;
import kr.co.ginong.web.repository.notice.NoticeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminCouponServiceImp")
public class CouponServiceImp implements CouponService {

    @Autowired
    private CouponRepository repository;

    @Autowired
    private CouponCategoryRepository categoryRepository;




    @Override
    public List<Coupon> getList() {
        return repository.findAll();
    }

    @Override
    public List<CouponCategory> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Coupon getById(Long id) {
        return repository.findById();
    }
}
