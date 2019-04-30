package com.billing.qrcode.main;

import com.billing.qrcode.generator.QRCodeGenerator;
import com.billing.qrcode.reader.QRCodeReader;
import com.billing.qrcode.schema.BillDetail;
import com.billing.qrcode.schema.Unit;
import com.google.gson.Gson;
import com.google.zxing.WriterException;

import java.io.File;
import java.io.IOException;

public class BillMain {
    public static void main(String[] args) throws WriterException, IOException {
        Gson gSon = new Gson();

        String qrCodeText = gSon.toJson(createBillDetailObject());
        System.out.println("qrCodeText:" + qrCodeText);
        String filePath = "/home/parshav/Documents/BillDetail.png";
        int size = 125;
        String fileType = "png";
        File qrFile = new File(filePath);
        QRCodeGenerator generator = new QRCodeGenerator();
        generator.createQRImage(qrFile, qrCodeText, size, fileType);
        System.out.println("QR Code Generated!! Path: " + filePath);

        //Reading and Printing QR data
        QRCodeReader reader = new QRCodeReader();
        String decoded = reader.decodeQRCode(new File(filePath));

        System.out.println("QR Code Data: " + decoded);

    }

    private static BillDetail createBillDetailObject() {
        BillDetail bd = new BillDetail();
        bd.setItemId("1");
        bd.setItemName("Book");
        bd.setPrice(100.05d);
        bd.setUnit(Unit.fromValue(Unit.DZ.name()));
        return bd;
    }
}

