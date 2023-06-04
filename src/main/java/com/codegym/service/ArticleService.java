package com.codegym.service;

import com.codegym.model.Article;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleService implements IArticleService{
    private static final List<Article> articles;

    static {
        articles = new ArrayList<>();
        articles.add(new Article(1, "Hot girl có 1,5 triệu fan diện váy ngủ quyến rũ bên khung cửa sổ", "Mới đây trên trang Weibo cá nhân hơn 1,5 triệu fan, hot girl Yuan Yuan gây chú ý khi đăng tải loạt ảnh diện váy lụa ngủ hai dây, ngồi tạo dáng bên khung cửa sổ.\n" +
                "\n" +
                "Được biết, Yuan Yuan đến từ Thượng Hải (Trung Quốc). Hiện cô đang làm người mẫu, kinh doanh cửa hàng thời trang trong nước. Người đẹp nhận được lượng theo dõi khủng trên các nền tảng mạng xã hội nhờ vào vẻ ngoài xinh đẹp và phong cách thời trang gợi cảm, sành điệu.", LocalDate.of(2023,10,10)));
        articles.add(new Article(2, "Bé gái lai xinh đẹp nhất thế giới\" mặc áo nịt, khoe vóc dáng nổi trội hơn bạn cùng lứa", "Mới đây, hình ảnh Ella Gross diện chiếc áo corset, tôn eo thon bên bạn học nhận được nhiều lượt yêu thích của cư dân mạng. Dưới phần bình luận, nhiều người hâm mộ dành lời khen ngợi cho Ella vì ngày càng ra dáng thiếu nữ. Thậm chí, khi đứng bên bạn cùng tuổi, sắc vóc của Ella trông có phần nổi bật hơn nhờ gương mặt quá xinh đẹp, thân hình cao lớn.", LocalDate.of(2023,10,10)));
        articles.add(new Article(3, "Mỹ nhân mặc đầm body khoe vóc dáng bên đường đẹp tới mức khó tin", "Jin Ye Young là người mẫu thời trang rất được yêu thích tại Hàn Quốc. Cô nàng gây chú ý với vóc dáng nóng bỏng cùng gương mặt ngây thơ. ", LocalDate.of(2023,10,10)));
        articles.add(new Article(4, "Lương Thùy Linh dẫn đầu xu hướng lăng xê mốt váy ngắn tới \"giật mình\"?", "Mùa hè là thời điểm để mốt váy áo ngắn \"lên ngôi\", được các tín đồ thời trang lăng xê nhiệt tình. Dẫn đầu trong dàn người đẹp nhan sắc Việt, hoa hậu Lương Thùy Linh chọn mặc chân váy siêu ngắn khi thả dáng ngoại cảnh. Cô phối chân váy xếp ly màu xanh với áo thun ngắn, giày thể thao và túi xách hàng hiệu. Tổng thể phong cách giúp Lương Thùy Linh trẻ trung và thu hút khi khoe đôi chân dài 1,22m.", LocalDate.of(2023,10,10)));
    }

    @Override
    public List<Article> findAll() {
        return new ArrayList<>(articles);
    }

    @Override
    public void save(Article article) {
        articles.add(article);
    }

    @Override
    public Article findById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Article article) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == id) {
                articles.set(i, article);
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        articles.removeIf(customer -> customer.getId() == id);
    }
}
