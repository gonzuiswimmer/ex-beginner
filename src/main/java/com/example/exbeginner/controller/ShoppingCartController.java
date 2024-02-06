package com.example.exbeginner.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exbeginner.model.Item;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("shopping-cart")
public class ShoppingCartController {
  @Autowired
  ServletContext application;
  @Autowired
  HttpSession session;
  
  @GetMapping({"","/"})
  public String index(Model model) {
    int total_price = 0;

    // item_listをアプリケーションスコープに格納
    if(application.getAttribute("item_list") == null) {
      List<Item> item_list = new LinkedList<>();
      Item note = new Item("手帳ノート",1000);
      Item stationerySet = new Item("文房具セット", 1500);
      Item file = new Item("ファイル", 2000);
      item_list.add(note);
      item_list.add(stationerySet);
      item_list.add(file);
      application.setAttribute("item_list", item_list);
    }

    // cart情報を取得または作成し、合計金額をセット
    if(session.getAttribute("cart") == null){
      List<Item> cart = new ArrayList<>();
      session.setAttribute("cart", cart);
    } else {
      List<Item> cart = (List<Item>) session.getAttribute("cart");
      for(Item item : cart){
        total_price += item.getPrice();
      }
    };
    model.addAttribute("total_price", total_price);
    
    return "item-and-cart";
  }
    
  @PostMapping("/inCart")
  public String inCart(Integer item_index, Model model) {
    System.out.println("カートに入れる商品のindex番号は" + item_index );
    int total_price = 0;

    // indexから追加する商品を取得し、cartセッションに追加して返却
    List<Item> item_list = (List<Item>) application.getAttribute("item_list");
    Item add_item = item_list.get(item_index);
    List<Item> cart = (List<Item>) session.getAttribute("cart");
    cart.add(add_item);
    session.setAttribute("cart", cart);
    model.addAttribute("total_price", total_price);
    
    return "redirect:/shopping-cart/";
  }

  @PostMapping("/delete")
  public String delete(Integer item_index) {
    System.out.println("削除する商品のindex番号は" + item_index );
    List<Item> cart = (List<Item>) session.getAttribute("cart");
    Item delete_item = cart.get(item_index);
    cart.remove(delete_item);
    session.setAttribute("cart", cart);

    return "redirect:/shopping-cart/";
  }
  
  
}
