package com.example.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    
    // private final ProductDAO productDAO;
    // private final MenuDAO menuDAO;
    // private final BoardDAO boardDAO;
    // private final FileDAO fileDAO;
    // private ProductDTO productDTO;

    // public List<ProductVO> showAll(){ return productDAO.showAll(); }

    // // 상품 등록
    // public void save(ProductDTO productDTO){
    //     productDAO.save(productDTO);
    //     List<FileVO> files = productDTO.getFiles();

    // // Optional : 검증
    //     Optional.ofNullable(files).ifPresent(fileList->{
    //         fileList.forEach(file->{
    //             file.setProId(productDTO.getProId());
    //             fileDAO.save((file));
    //         });
    //     });
    // }
    // 메뉴
    // public List<MenuVO> showMenu(){return menuDAO.showMenu();}
    

}
