package GJK;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.wp.usermodel.CharacterRun;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import pojo.textObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Test {


    /*
    * 通过 XWPFWordExtractor访问XWPFDocument的内容
    * */

    public void testReadByExtractor(XWPFDocument document){

        XWPFWordExtractor extractor = new XWPFWordExtractor(document);

        String content = extractor.getText();

        System.out.println("通过XWPFWordExtractor读取XWPFDocumt内容：");
        System.out.println(content);

        System.out.println("输出CorePropeties：");
        POIXMLProperties.CoreProperties coreProps = extractor.getCoreProperties();
        System.out.println(coreProps.getCategory());   //分类
        System.out.println(coreProps.getCreator()); //创建者
        System.out.println(coreProps.getCreated()); //创建时间
        System.out.println(coreProps.getTitle());   //标题

    }

    public static void main(String[] args) throws IOException {

        Test test = new Test();
        //文件路径
        String path = "E:\\NJU\\Goverment\\src\\main\\resources\\政策\\关于组织开展2020年度首批省星级上云企业认定工作的通知.docx";
        // 读取文件
        InputStream inputStream = new FileInputStream(path);

        //创建XWPF对象
        XWPFDocument document = new XWPFDocument(inputStream);

        //获取所有段落
        List<XWPFParagraph> paras = document.getParagraphs();

        // 删除空白段
        List<String> paragraphList = new ArrayList<>();
        for (XWPFParagraph para:paras){
            String paraContent = para.getText();
            //CTPPr pr = para.getCTP().getPPr();
            if (!paraContent.equals(""))
                paragraphList.add(paraContent);
        }

        //获取通知主体一级标题
        int i,j,k=0;
        for (String para : paragraphList){
            if (para.contains("一、")){
                i=paragraphList.indexOf(para);
                System.out.println(para);
            }
            if (para.contains("二、")){
                j=paragraphList.indexOf(para);
                System.out.println(para);
            }
            if (para.contains("三、")){
                k=paragraphList.indexOf(para);
                System.out.println(para);
            }
        }






        //通过extractor读取xwpfdocument内容
        //test.testReadByExtractor(document);


    }
}
