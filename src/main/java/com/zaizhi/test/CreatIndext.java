package com.zaizhi.test;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;

/**
 * Created by 吴凡 on 2019/4/11.
 */
public class CreatIndext {

    public static void main(String[] args) throws Exception {

        Directory dir = FSDirectory.open(new File("E:/后期项目/lucene/index"));
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_44);
        IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_44,analyzer);
        IndexWriter indexWriter = new IndexWriter(dir, conf);

        Document document = new Document();
        document.add(new StringField("id","1", Field.Store.YES));
        document.add(new StringField("title","背景", Field.Store.YES));
        document.add(new StringField("author","朱自清", Field.Store.YES));
        document.add(new TextField("content","你在这，不要动，橘子", Field.Store.YES));
        document.add(new StringField("date","2019-04-15", Field.Store.YES));

        indexWriter.addDocument(document);

        indexWriter.commit();
        indexWriter.close();

    }
}
