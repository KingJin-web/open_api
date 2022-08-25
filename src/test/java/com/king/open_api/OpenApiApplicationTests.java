//package com.king.open_api;
//
//import com.alibaba.fastjson2.JSON;
//import com.alibaba.fastjson2.JSONArray;
//import com.alibaba.fastjson2.JSONObject;
//import com.kennycason.kumo.*;
//import com.kennycason.kumo.bg.CircleBackground;
//import com.kennycason.kumo.bg.RectangleBackground;
//import com.kennycason.kumo.font.KumoFont;
//import com.kennycason.kumo.font.scale.LinearFontScalar;
//import com.kennycason.kumo.font.scale.SqrtFontScalar;
//import com.kennycason.kumo.image.AngleGenerator;
//import com.kennycason.kumo.nlp.FrequencyAnalyzer;
//import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
//import com.kennycason.kumo.palette.ColorPalette;
//import com.king.open_api.service.GetHotNewsServiceImpl;
//import com.king.open_api.util.HttpUtils;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.awt.*;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@SpringBootTest
//public class OpenApiApplicationTests {
//
//    @Test
//    public void contextLoads() {
//
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
//
//        LocalDate localDate = LocalDate.parse("08-05", formatter);
//        System.out.println(localDate);
//    }
//
//    @Test
//    public void test() {
//        //:authority: mcs.zijieapi.com
//        //:method: POST
//        //:path: /list
//        //:scheme: https
//        //accept: */*
//        //accept-encoding: gzip, deflate, br
//        //accept-language: zh-CN,zh;q=0.9
//        //content-length: 1783
//        Map<String, String> map = new HashMap<>();
//        map.put("authority", "");
//
//        String s = HttpUtils.get("https://www.iesdouyin.com/web/api/v2/hotsearch/billboard/word/?reflow_source=reflow_page");
//
//        JSONArray jsonArray = JSON.parseObject(s).getJSONArray("word_list");
//
//        System.out.println(s);
//    }
//
//    @Autowired
//    private GetHotNewsServiceImpl getHotNewsService;
//
//    @Test
//    public void test2() {
//        //创建一个词语解析器,类似于分词
//        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
//        frequencyAnalyzer.setWordFrequenciesToReturn(600);
//        frequencyAnalyzer.setMinWordLength(2);
//        //这边要注意,引用了中文的解析器
//        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
//        //拿到文档里面分出的词,和词频,建立一个集合存储起来
//        List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(getHotNewsService.getHotNews4(20));
//        Dimension dimension = new Dimension(600, 600);
//        //设置图片相关的属性,这边是大小和形状,更多的形状属性,可以从CollisionMode源码里面查找
//        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
//        wordCloud.setPadding(2);
//        //这边要注意意思,是设置中文字体的,如果不设置,得到的将会是乱码,
//        //这是官方给出的代码没有写的,我这边拓展写一下,字体,大小可以设置
//        //具体可以参照Font源码
//      Font font = new Font("STSong-Light", Font.ITALIC, 16);
//        wordCloud.setKumoFont(new KumoFont(font));
//        wordCloud.setBackgroundColor(new Color(255, 255, 255));
//        //因为我这边是生成一个圆形,这边设置圆的半径
//        wordCloud.setBackground(new CircleBackground(255));
//        //设置颜色
//        wordCloud.setColorPalette(new ColorPalette(Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW));
//        wordCloud.setFontScalar(new SqrtFontScalar(12, 45));
//        //将文字写入图片
//        wordCloud.build(wordFrequencies);
//        //生成图片
//        wordCloud.writeToFile("H:\\jetbrains\\java\\open_api\\src\\main\\resources\\static\\chinese_language_circle.png");
//    }
//
//    private static final String path = "H:\\jetbrains\\java\\open_api\\src\\main\\resources\\static\\chinese_language_circle.png";
//
//    @Test
//    public void test3() {
//        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
//        frequencyAnalyzer.setWordFrequenciesToReturn(1);
//        frequencyAnalyzer.setMinWordLength(2);
//        //这边要注意,引用了中文的解析器
//        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
//        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(getHotNewsService.getHotNews4(20));
//        final Dimension dimension = new Dimension(600, 600);
//        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
//        Font font = new Font("STSong-Light", Font.ITALIC, 16);
//        wordCloud.setKumoFont(new KumoFont(font));
//        wordCloud.setPadding(0);
//        wordCloud.setBackground(new RectangleBackground(dimension));
//        wordCloud.setColorPalette(new ColorPalette(Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE));
//        wordCloud.setFontScalar(new LinearFontScalar(10, 40));
//        wordCloud.build(wordFrequencies);
//        wordCloud.writeToFile(path);
//    }
//
//    @Test
//    public void dragonChinese() throws IOException {
//        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
//        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
//        frequencyAnalyzer.setWordFrequenciesToReturn(900);
//        frequencyAnalyzer.setMinWordLength(1);
//     //   frequencyAnalyzer.setStopWords(Arrays.asList("是", "不", "了", "的", "个", "子"));
//
//        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(getHotNewsService.getHotNews4(20));
//        final Dimension dimension = new Dimension(555, 555);
//        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
//        wordCloud.setPadding(1);
//        Font font = new Font("宋体", Font.ITALIC, 16);
//        wordCloud.setKumoFont(new KumoFont(font));
//       // wordCloud.setBackgroundColor(new Color(0xE35A05));
//        wordCloud.setAngleGenerator(new AngleGenerator(0));
//     //   wordCloud.setBackground(new PixelBoundryBackground(getInputStream("backgrounds/dragon.png")));
//        wordCloud.setColorPalette(new ColorPalette(new Color(0x0), new Color(0x333333), new Color(0x555555)));
//        wordCloud.setFontScalar(new SqrtFontScalar(6, 50));
//        wordCloud.build(wordFrequencies);
//        wordCloud.writeToFile(path);
//    }
//
////    @Test
////    public void chineseCircle() throws IOException {
////        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
////        frequencyAnalyzer.setWordFrequenciesToReturn(600);
////        frequencyAnalyzer.setMinWordLength(2);
////        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
////
////        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(getInputStream("text/chinese_language.txt"));
////        final Dimension dimension = new Dimension(600, 600);
////        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
////        wordCloud.setPadding(2);
////        wordCloud.setBackground(new CircleBackground(300));
////        wordCloud.setColorPalette(new ColorPalette(new Color(0xD5CFFA), new Color(0xBBB1FA), new Color(0x9A8CF5), new Color(0x806EF5)));
////        wordCloud.setFontScalar(new SqrtFontScalar(12, 45));
////        final long startTime = System.currentTimeMillis();
////        wordCloud.build(wordFrequencies);
////        LOGGER.info("Took " + (System.currentTimeMillis() - startTime) + "ms to build");
////        wordCloud.writeToFile("output/chinese_language_circle.png");
////    }
////
////    @Test
////    public void chineseVsEnglishTideComments() throws IOException {
////        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
////        frequencyAnalyzer.setWordFrequenciesToReturn(750);
////        frequencyAnalyzer.setMinWordLength(3);
////        frequencyAnalyzer.setStopWords(loadStopWords());
////        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(getInputStream("text/english_tide.txt"));
////
////        final FrequencyAnalyzer chineseFrequencyAnalyzer = new FrequencyAnalyzer();
////        chineseFrequencyAnalyzer.setWordFrequenciesToReturn(750);
////        chineseFrequencyAnalyzer.setMinWordLength(2);
////        chineseFrequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
////        final List<WordFrequency> wordFrequencies2 = chineseFrequencyAnalyzer.load(getInputStream("text/chinese_tide.txt"));
////
////        final Dimension dimension = new Dimension(800, 600);
////        final PolarWordCloud wordCloud = new PolarWordCloud(dimension, CollisionMode.PIXEL_PERFECT, PolarBlendMode.BLUR);
////        wordCloud.setPadding(2);
////        wordCloud.setBackground(new RectangleBackground(dimension));
////        wordCloud.setFontScalar(new SqrtFontScalar(10, 70));
////
////        final ColorPalette colorPalette = new ColorPalette(new Color(0xD5CFFA), new Color(0xBBB1FA), new Color(0x9A8CF5), new Color(0x806EF5));
////        final ColorPalette colorPalette2 = new ColorPalette(new Color(0xFA8E8E), new Color(0xF77979), new Color(0xF55F5F), new Color(0xF24949));
////        wordCloud.setColorPalette(colorPalette);
////        wordCloud.setColorPalette2(colorPalette2);
////
////        final long startTime = System.currentTimeMillis();
////        wordCloud.build(wordFrequencies, wordFrequencies2);
////        LOGGER.info("Took " + (System.currentTimeMillis() - startTime) + "ms to build");
////        wordCloud.writeToFile("output/polar_tide_chinese_vs_english2.png");
////    }
//}
