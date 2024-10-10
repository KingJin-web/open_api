package com.king.open_api.util;

import cn.hutool.core.io.resource.ResourceUtil;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.RectangleBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.ColorPalette;
import com.king.open_api.service.BaiduApiServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class WordCodeUtil {

   private static final Logger logger = LoggerFactory.getLogger(WordCodeUtil.class);

    public static WordCloud getWordCode(List<String> words) {
        words.remove(words.size() - 1);
        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(600);

        frequencyAnalyzer.setMinWordLength(3);
        // 引入中文解析器
        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
        final List<WordFrequency> wordFrequencyList = frequencyAnalyzer.load(words);
        int i = words.size();
        for (String s : words) {
            wordFrequencyList.add(new WordFrequency(s, i--));
        }
        // 设置图片分辨率
        Dimension dimension = new Dimension(940, 400);
        // 创建词云对象
        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        // 加载字体文件
        try (BufferedInputStream bis = getFileFromResource("LXGWWenKaiMono-Bold.ttf")) {
            Font font = Font.createFont(Font.TRUETYPE_FONT, bis);
            wordCloud.setKumoFont(new KumoFont(font));
        } catch (IOException e) {
           logger.error("加载字体文件失败！",e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }

        // 设置词云样式
        wordCloud.setPadding(3);
        wordCloud.setColorPalette(new ColorPalette(
                new Color(0xed1941), new Color(0xf26522), new Color(0x845538),
                new Color(0x8a5d19), new Color(0x7f7522), new Color(0x5c7a29),
                new Color(0x1d953f), new Color(0x007d65), new Color(0x65c294)
        ));
        wordCloud.setBackground(new RectangleBackground(dimension));
        wordCloud.setFontScalar(new SqrtFontScalar(12, 45));
        wordCloud.setBackgroundColor(new Color(255, 255, 255));

        // 生成词云
        wordCloud.build(wordFrequencyList);


        return wordCloud;



    }

    //返回Base64到览器
    public static String getWordCloud2(List<String> words){
        return BufferedImageToBase64(getWordCode(words).getBufferedImage());
    }

    public static void getWordCloud3(List<String> words ,
                                     HttpServletResponse response) throws IOException {
       WordCloud wordCloud = getWordCode(words);
       wordCloud.writeToStreamAsPNG(response.getOutputStream());
       response.flushBuffer();
    }


    /**
     * 方法六：使用Hutool的ResourceUtil
     * 备注：jar包可用
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static BufferedInputStream getFileFromResource(String fileName) throws IOException {
        List<URL> resources = ResourceUtil.getResources(fileName);
        URL resource = resources.get(0);
        return new BufferedInputStream(resource.openStream());
    }



    /**
     * BufferedImage 编码转换为 base64
     * @param bufferedImage
     * @return
     */
    private static String BufferedImageToBase64(BufferedImage bufferedImage) {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();//io流
        try {
            ImageIO.write(bufferedImage, "png", bao);//写入流中
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
        byte[] bytes = Base64.getEncoder().encode(bao.toByteArray());
        String base64 = new String(bytes);
        base64 = base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
        return "data:image/png;base64," + base64;
    }
}
