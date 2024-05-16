package kr.co.ginong.web.controller;

import kr.co.ginong.web.entity.product.ProductView;
import kr.co.ginong.web.service.user.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = {"/", "/index", "/home"})
public class IndexController {

    @Autowired
    private ProductService service;

    @GetMapping
    String index(Model model) {
        List<ProductView> seasonOutList = service.getSeasonOutList();
        List<ProductView> commingSoonList = service.getCommingSoonList();

        // todo findAllBestProduct / 베스트 상품 기능 만들기 / 판매일, 누적 판매량 필요 / 월 단위로 어떻게 끊을지 생각해보기
        List<ProductView> bestProductList; // 미개발

        List<ProductView> saleProductList = service.getSaleProductList();
        List<ProductView> pickProductList = service.getPickProductList();

        // 추후 top(x) 개 출력하는 매퍼 완성되면 for문으로 변경 예정
        ProductView saleProduct = saleProductList.get(0);
        ProductView pickProduct = pickProductList.get(0);

        model.addAttribute("saleProduct", saleProduct);             // 베스트 상품     (판매량최대상품)
        model.addAttribute("pickProduct", pickProduct);             // 추천 상품       (좋아요최대상품)
        model.addAttribute("seasonOutList", seasonOutList);         // 시즌아웃임박상품 (시즌 종료일이 D-14일인 상품)
        model.addAttribute("commingSoonList", commingSoonList);     // 커밍순상품      (시즌 시작일이 D-14일인 상품)

        return "index";
    }


    @GetMapping("test")
    String test(Model model) {
        return "test";
    }
}
