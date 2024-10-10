//package com.king.open_api;
//
//
//import com.huaban.analysis.jieba.JiebaSegmenter;
//import com.kennycason.kumo.CollisionMode;
//import com.kennycason.kumo.WordCloud;
//import com.kennycason.kumo.WordFrequency;
//import com.kennycason.kumo.bg.CircleBackground;
//import com.kennycason.kumo.bg.RectangleBackground;
//import com.kennycason.kumo.font.KumoFont;
//import com.kennycason.kumo.font.scale.SqrtFontScalar;
//import com.kennycason.kumo.nlp.FrequencyAnalyzer;
//import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
//import com.kennycason.kumo.palette.ColorPalette;
//import com.kennycason.kumo.palette.LinearGradientColorPalette;
//
//import java.awt.*;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.*;
//import java.util.List;
//
//
//class T00_WordCountSample {
//
//
//    private static void createWordCountPic() {
//        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
//        frequencyAnalyzer.setWordFrequenciesToReturn(600);
//        frequencyAnalyzer.setMinWordLength(2);
//        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
//        // 可以直接从文件中读取
//        //List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(getInputStream("D:\\citydo-one\\技术\\Java_Note-master\\python\\tp\\Trump.txt"));
//        List<WordFrequency> wordFrequencies = new ArrayList<>();
//        // 用词语来随机生成词云
//        String strValue = "菠萝=20, 草莓=20, 苹果=10, 西红柿=15, 榴莲=15,  西瓜=4, 猕猴桃=4, 火龙果=4";
//
//        //以逗号为分割号
//        String[] split = strValue.split(", ");
//        String word = "";
//        int count = 0;
//
//        for (int i = 0; i < split.length; i++) {
//            String[] wordInfo = split[i].split("=");
//            word = wordInfo[0];
//            count = Integer.valueOf(wordInfo[1]);
//            wordFrequencies.add(new WordFrequency(word, count));
//        }
//        //加入分词并随机生成权重，每次生成得图片都不一样
//        //test.stream().forEach(e-> wordFrequencies.add(new WordFrequency(e,new Random().nextInt(test.size()))));
//        //此处不设置会出现中文乱码
//        java.awt.Font font = new java.awt.Font("STSong-Light", 2, 18);
//        //设置图片分辨率
//        Dimension dimension = new Dimension(500, 500);
//        //此处的设置采用内置常量即可，生成词云对象
//        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
//        //设置边界及字体
//        wordCloud.setPadding(2);
//        //因为我这边是生成一个圆形,这边设置圆的半径
//        wordCloud.setBackground(new CircleBackground(255));
//        wordCloud.setFontScalar(new SqrtFontScalar(12, 42));
//        //设置词云显示的三种颜色，越靠前设置表示词频越高的词语的颜色
//        wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
//        wordCloud.setKumoFont(new KumoFont(font));
//        wordCloud.setBackgroundColor(new Color(255, 255, 255));
//        //因为我这边是生成一个圆形,这边设置圆的半径
//        wordCloud.setBackground(new CircleBackground(255));
//        wordCloud.build(wordFrequencies);
//        //生成词云图路径
//        wordCloud.writeToFile("E:\\词云.png");
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        String hotword = "美妆一哥回归 曾涉虚假宣传赔1.5亿。出现下跌 A股后市会如何。北交所创下多项历史纪录。孙颖莎vs杜凯琹。我国住院率破20%大关。中国女团3:1朝鲜女团。警方通报昆明长水机场出境被坑钱。张家界回应被指拆成20个景区收费。A股迎近期首次大调整 是何原因？。女子怀孕工资从6000降到3000。A股大跌。文脉赓续 弦歌不辍。原神5.1版本。崔永熙NBA首秀。新加坡开国总理李光耀之女去世。太阳轻取活塞。苗疆陈朵朵道歉。我国加力推出增量政策重点在五方面。哀牢山最危险的不是猛兽。朝鲜：完全切断与韩国连接的铁路公路。坐热气球看卢克索日出。拼凑信息发谣言，抓！。车在停车位上被拖走 交警：领导让拖的。05后大学生股民跑步进场交易被套。文泰一被警方立案第二天生日直播。17年的玩具我24年开了眼界。国庆假期国内出游7.65亿人次。充上电那一刻玩具升值了。小虎手势舞传到海外了。朝鲜永久切断并封锁与韩国交界南部国境。A股开盘近5000只个股下跌。孙颖莎3比0杜凯琹。密逃这期有杨幂黄明昊。亚锦赛转播画质。加力推出一揽子增量政策。上海爷叔为何能成为最火股民。市监局回应东北雨姐红薯粉条事件。伊能静被我恋6男嘉宾气到疯狂输出。中方敦促土耳其：立即纠正错误做法。五大券商集体发声致信新股民。";
//        JiebaSegmenter segmenter = new JiebaSegmenter();
//
//        System.out.println(segmenter.process(hotword, JiebaSegmenter.SegMode.SEARCH).toString());
//
//
//        String hotwords[] = hotword.split("。");
//        getWordCloud2(Arrays.asList(hotwords));
//        return;
//
//    }
//
//    public static <OutputStream> String getWordCloud(List<String> words) {
//        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
//        frequencyAnalyzer.setWordFrequenciesToReturn(600);
//        frequencyAnalyzer.setMinWordLength(2);
//
//        // 引入中文解析器
//        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
//
//        final List<WordFrequency> wordFrequencyList = new ArrayList<>();
//        int i = words.size();
//        for (String word : words) {
//            wordFrequencyList.add(new WordFrequency(word, i--));
//        }
//
//        // 设置图片分辨率940x400
//        Dimension dimension = new Dimension(940, 400);
//        // 此处的设置采用内置常量即可，生成词云对象
//        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
//        java.awt.Font font = new java.awt.Font("STSong-Light", 2, 18);
//        wordCloud.setKumoFont(new KumoFont(font));
//        wordCloud.setPadding(2);
//        wordCloud.setColorPalette(new ColorPalette(new Color(0xed1941), new Color(0xf26522), new Color(0x845538), new Color(0x8a5d19), new Color(0x7f7522), new Color(0x5c7a29), new Color(0x1d953f), new Color(0x007d65), new Color(0x65c294)));
//        wordCloud.setBackground(new RectangleBackground(dimension));
//        wordCloud.setFontScalar(new SqrtFontScalar(10, 40));
//        wordCloud.setBackgroundColor(new Color(255, 255, 255));
//        // 生成词云
//        wordCloud.build(wordFrequencyList);
//        wordCloud.writeToFile("wordcloud_gradient_redbluegreen.png");
////
//        return null;
//    }
//
//    public static <OutputStream> String getWordCloud2(List<String> words) {
//        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
//        frequencyAnalyzer.setWordFrequenciesToReturn(600);
//        frequencyAnalyzer.setMinWordLength(2);
//
//        // 引入中文解析器
//        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
//
//        final List<WordFrequency> wordFrequencyList = frequencyAnalyzer.load(words);
//
//
//        // 设置图片分辨率940x400
//        Dimension dimension = new Dimension(940, 400);
//        // 此处的设置采用内置常量即可，生成词云对象
//        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
//        java.awt.Font font = new java.awt.Font("STSong-Light", 2, 18);
//        wordCloud.setKumoFont(new KumoFont(font));
//        wordCloud.setPadding(1);
//        wordCloud.setColorPalette(new ColorPalette(new Color(0xed1941), new Color(0xf26522), new Color(0x845538), new Color(0x8a5d19), new Color(0x7f7522), new Color(0x5c7a29), new Color(0x1d953f), new Color(0x007d65), new Color(0x65c294)));
//        wordCloud.setBackground(new RectangleBackground(dimension));
//        wordCloud.setFontScalar(new SqrtFontScalar(12, 45));
//        wordCloud.setBackgroundColor(new Color(255, 255, 255));
//        // 生成词云
//        wordCloud.build(wordFrequencyList);
//        wordCloud.writeToFile("wordcloud_gradient_redbluegreen.png");
////
//        return null;
//    }
//}