//package com.Aris.esd_document.Service.internalService;
//
//import DeleteDocumentRequest;
//import SaveDocumentRequest;
//import UpdateDocumentRequest;
//import Document;
//import RepoDocument;
//import com.Aris.esd_document.proxy.*;
//import com.Aris.esd_document.proxy.proxyDitel.*;
//import HazelCastUtility;
//import DocumentResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DocumentCrudInternalService {
//
//    final RepoDocument repoDocument;
//    final HazelCastUtility hazelCastUtility;
//    final DocInfoProxy docInfoProxy;
//    final DocElasticProxy docElasticProxy;
//    final ProxyApplicant proxyApplicant;
//    final ProxyDocType proxyDocType;
//    final ProxyDepartment proxyDepartment;
//
//    public DocumentCrudInternalService(RepoDocument repoDocument, HazelCastUtility hazelCastUtility, DocInfoProxy docInfoProxy, DocElasticProxy docElasticProxy, ProxyApplicant proxyApplicant, ProxyDocType proxyDocType, ProxyDepartment proxyDepartment) {
//        this.repoDocument = repoDocument;
//        this.hazelCastUtility = hazelCastUtility;
//        this.docInfoProxy = docInfoProxy;
//        this.docElasticProxy = docElasticProxy;
//        this.proxyApplicant = proxyApplicant;
//        this.proxyDocType = proxyDocType;
//        this.proxyDepartment = proxyDepartment;
//    }
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    public DocumentResponse saveDocument(SaveDocumentRequest saveDocumentRequest) {
//        DocumentResponse documentResponse = new DocumentResponse();
//        try {
//            Document document = new Document();
//
//            document.setDocumentCode("");
//
//
//            document.setIdDocumentType(saveDocumentRequest.getIdDocumentType());
//            document.setIdApplicant(saveDocumentRequest.getIdApplicant());
//            document.setIdDepartment(saveDocumentRequest.getIdDepartment());
//            document.setOrganisation(saveDocumentRequest.getOrganisation());
//            document.setNote(saveDocumentRequest.getNote());
//            document.setIdCreatedEmp(saveDocumentRequest.getIdCreatedEmp());
//            document.setIsVisible(1);
//            document.setIsDelete(0);
//            document.setIsControl(saveDocumentRequest.getIsControl());
//            document.setVereqSayi(saveDocumentRequest.getVereqSayi());
//            document.setQosma(saveDocumentRequest.getQosma());
//            document.setQosmaSayi(saveDocumentRequest.getQosmaSayi());
//
//            document.setExpiredDate(saveDocumentRequest.getExpiredDate());
//            document.setDocumentEnteredDate(saveDocumentRequest.getDocumentEnteredDate());
//            document.setIsMoved(saveDocumentRequest.getIsMoved());
//            document.setOrgDate(saveDocumentRequest.getOrgDate());
//            document.setOrgNo(saveDocumentRequest.getOrgNo());
//
//            document.setCombineDocument(saveDocumentRequest.getCombineDocument());
//            document.setOrganisation(saveDocumentRequest.getOrganisation());
//
////            document= repoDocument.save(document);
//
//            document = hazelCastUtility.save(document);
//            logger.info("step1-----------------document :{}", document);
//
//            //senedin codunun alinmasi
//            //01 BNA nin kodu veya butun idarenin kodu
////            String docCode = "01-" + document.getIdDepartment() + "-";
////            String docIDForCode = document.getIdDocument() + "";
////            for (int i = 0; i < 10 - docIDForCode.length(); i++) {
////                docCode += "0";
////            }
////            docCode += docIDForCode;
////            document.setDocumentCode(docCode);
//
//
//            ResponseApplicant responseApplicant = proxyApplicant.getApplicantIdApplicant(document.getIdApplicant());
//            logger.info("responseApplicant :{}", responseApplicant.toString());
//            ResponseSearchDocType responseDocType = proxyDocType.getDocMovByIdDocType(document.getIdDocumentType());
//            logger.info(" responseDocType:{}", responseDocType.toString());
//
//            ResponseSearchDepartmentByIdDep responseDep = proxyDepartment.getDepartmentIdDep(document.getIdDepartment());
//            logger.info(" responseDep:{}", responseDep.toString());
//
//            // TODO: 26/08/2019
//            // vetendaslardan daxil olan senedlere gore kodun verilmesi
//
//            //PA huquqi ve xidmeti sened
//            if (responseApplicant.getApplicant() != null) {
//                if (responseApplicant.getApplicant().getIsKollektiv() == 0  && responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 152) {
//
//                    logger.info(" hazel responseApplicant.getApplicant().getIsKollektiv() == 0 &&responseDocType.getDocumentMovByidDocumentType().getIdDocumentType()==2\n" +
//                            "                        &&responseDocType.getDocumentMovByidDocumentType().getIdDocumentType()==3 :{}", responseApplicant.getApplicant().toString());
//                    String s = "";
//                    s += getDocCount(document.getIdDocumentType());
//
////                    String docIDForCode = document.getIdDocument() + "";
////                    for (int i = 0; i < 1 - docIDForCode.length(); i++) {
////                        s += "0";
////
////                    }
//
//
//                    while (s.length() < 5) {
//                        s = "0" + s;
//                    }
//                    String docCode1 = responseApplicant.getApplicant().getSurName().substring(0, 1) + "-" + s + "-" + "01" + "-" + responseDocType.getDocumentMovByidDocumentType().getDocumentTitle().substring(0, 3);
//                    document.setDocumentCode(docCode1);
//                    logger.info("document.SetDocCode :{}", document.toString());
//                }
//
////                Milli meclis huqiqi ve sened
//                else if (responseApplicant.getApplicant().getIsKollektiv() == 0 && responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 153&&responseDocType.getDocumentMovByidDocumentType().getType()==0) {
//                    logger.info("***********HazelCastUtility********responseApplicant.getApplicant().getIsKollektiv() :{}", responseApplicant.getApplicant().getIsKollektiv());
//                    String s = "";
//                    s += getDocCount(document.getIdDocumentType());
//
//                    while (s.length() < 5) {
//                        s = "0" + s;
//                    }
//                    String docCode1 = responseApplicant.getApplicant().getSurName().substring(0, 1) + "-" + s + "-" + "02" + "-" + responseDocType.getDocumentMovByidDocumentType().getDocumentTitle().substring(0, 3);
//                    document.setDocumentCode(docCode1);
//
//                }
//
////                Nazirler kabineti huquqi sened
//                else if (responseApplicant.getApplicant().getIsKollektiv() == 0 && responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 154) {
//                    logger.info("***********HazelCastUtility********responseApplicant.getApplicant().getIsKollektiv() :{}", responseApplicant.getApplicant().getIsKollektiv());
//                    String s = "";
//                    s += getDocCount(document.getIdDocumentType());
//
//
//                    while (s.length() < 5) {
//                        s = "0" + s;
//                    }
//                    String docCode1 = responseApplicant.getApplicant().getSurName().substring(0, 1) + "-" + s + "-" + "03" + "-" + responseDocType.getDocumentMovByidDocumentType().getDocumentTitle().substring(0, 3);
//                    document.setDocumentCode(docCode1);
//
//                }
//
//                //                Diger qurumlar huquqi ve xidmeti
//                else if (responseApplicant.getApplicant().getIsKollektiv() == 0 && responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 155) {
//                    logger.info("***********HazelCastUtility********responseApplicant.getApplicant().getIsKollektiv() :{}", responseApplicant.getApplicant().getIsKollektiv());
//                    String s = "";
//                    s += getDocCount(document.getIdDocumentType());
//
//
//                    while (s.length() < 5) {
//                        s = "0" + s;
//                    }
//                    String docCode1 = responseApplicant.getApplicant().getSurName().substring(0, 1) + "-" + s + "-" + "04" + "-" + responseDocType.getDocumentMovByidDocumentType().getDocumentTitle().substring(0, 3);
//                    document.setDocumentCode(docCode1);
//
//                }
//
////                PA -nin huquqi ve xidmeti kollektiv olmasi
//                else if (responseApplicant.getApplicant().getIsKollektiv() == 1 && responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 152) {
//                    logger.info("----------HazelCastUtility---------responseApplicant.getApplicant().getIsKollektiv() :{}", responseApplicant.getApplicant().getIsKollektiv());
//                    String s = "";
//                    s += getDocCount(document.getIdDocumentType());
//
//                    while (s.length() < 5) {
//                        s = "0" + s;
//                    }
//                    String docCode1 = "Kol" + "-" + s + "-" + "01" + responseDocType.getDocumentMovByidDocumentType().getDocumentTitle().substring(0, 3);
//                    document.setDocumentCode(docCode1);
//
//                }
//                //                MM -nin huquqi ve xidmeti kollektiv olmasi
//                else if (responseApplicant.getApplicant().getIsKollektiv() == 1 && responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 153) {
//                    logger.info("----------HazelCastUtility---------responseApplicant.getApplicant().getIsKollektiv() :{}", responseApplicant.getApplicant().getIsKollektiv());
//                    String s = "";
//                    s += getDocCount(document.getIdDocumentType());
//
//                    while (s.length() < 5) {
//                        s = "0" + s;
//                    }
//                    String docCode1 = "Kol" + "-" + s + "-" + "02" + responseDocType.getDocumentMovByidDocumentType().getDocumentTitle().substring(0, 3);
//                    document.setDocumentCode(docCode1);
//
//                }
//
//                //                NK -nin huquqi ve xidmeti kollektiv olmasi
//                else if (responseApplicant.getApplicant().getIsKollektiv() == 1 && responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 154) {
//                    logger.info("----------HazelCastUtility---------responseApplicant.getApplicant().getIsKollektiv() :{}", responseApplicant.getApplicant().getIsKollektiv());
//                    String s = "";
//                    s += getDocCount(document.getIdDocumentType());
//
//                    while (s.length() < 5) {
//                        s = "0" + s;
//                    }
//                    String docCode1 = "Kol" + "-" + s + "-" + "03" + responseDocType.getDocumentMovByidDocumentType().getDocumentTitle().substring(0, 3);
//                    document.setDocumentCode(docCode1);
//
//                }
//
//                //                Diger qurumlar-nin huquqi kollektiv olmasi
//                else if (responseApplicant.getApplicant().getIsKollektiv() == 1 && responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 155) {
//                    logger.info("----------HazelCastUtility---------responseApplicant.getApplicant().getIsKollektiv() :{}", responseApplicant.getApplicant().getIsKollektiv());
//                    String s = "";
//                    s += getDocCount(document.getIdDocumentType());
//
//                    while (s.length() < 5) {
//                        s = "0" + s;
//                    }
//                    String docCode1 = "Kol" + "-" + s + "-" + "03" + responseDocType.getDocumentMovByidDocumentType().getDocumentTitle().substring(0, 3);
//                    document.setDocumentCode(docCode1);
//
//                }
//            }
//
////            else if (responseDocType.getDocumentMovByidDocumentType().getType() == 1) {
////                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{}", responseDocType.getDocumentMovByidDocumentType().getType());
////                String s = "";
////                String docIDForCode = document.getIdDocument()+"";
////                for (int i = 0; i < 1 - s.length(); i++) {
////                    s += "0";
////
////                }
////                s+=docIDForCode;
////                while (s.length() < 5) {
////                    s = "0" + s;
////                }
////                String docCode1 = responseDocType.getDocumentMovByidDocumentType().getDocumentTitle().substring(0,1) + "-" + s;
////                document.setDocumentCode(docCode1);
////                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
////            }
//
//            //qurumdan gelen senedler
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 2) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{}", responseDocType.getDocumentMovByidDocumentType().getType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-01-01" + "-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            } else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 3) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{}", responseDocType.getDocumentMovByidDocumentType().getType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-02-01" + "-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            } else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 5) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{}", responseDocType.getDocumentMovByidDocumentType().getType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-01-02" + "-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            } else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 6) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{}", responseDocType.getDocumentMovByidDocumentType().getType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-02-02" + "-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            } else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 8) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{}", responseDocType.getDocumentMovByidDocumentType().getType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-01-03-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            } else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 9) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{}", responseDocType.getDocumentMovByidDocumentType().getType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-02-03" + "-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            } else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 11) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{}", responseDocType.getDocumentMovByidDocumentType().getType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-02-01" + "-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            } else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 12) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{}", responseDocType.getDocumentMovByidDocumentType().getType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-02-01" + "-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
//
//            //Dasiyicidan daxil olan senedler
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getType() == 4) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{}", responseDocType.getDocumentMovByidDocumentType().getType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-07-h" + "-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            } else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getType() == 5) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{}", responseDocType.getDocumentMovByidDocumentType().getType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-07-f" + "-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
//            //daxil olan telefoqnarama
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 91) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType() :{}", responseDocType.getDocumentMovByidDocumentType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-06-T" + "-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
//            //sorgu
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 92) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType() :{}", responseDocType.getDocumentMovByidDocumentType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
//            // inzibati emr
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 148) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType() :{}", responseDocType.getDocumentMovByidDocumentType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-12-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
//            // kadr emr
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 149) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType() :{}", responseDocType.getDocumentMovByidDocumentType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-13-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
//            // ezamiyyet emr
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 150) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType() :{}", responseDocType.getDocumentMovByidDocumentType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-14-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
//            // serencam
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 95) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType() :{}", responseDocType.getDocumentMovByidDocumentType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "S-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
////            qerar
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 94) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType() :{}", responseDocType.getDocumentMovByidDocumentType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "Q-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
//
//            //erize
//
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 97) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType() :{}", responseDocType.getDocumentMovByidDocumentType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "12-15-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
//            //arayis
//
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 98) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType() :{}", responseDocType.getDocumentMovByidDocumentType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-18-" + s + "-A";
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
//            //etibarname
//
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 99) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType() :{}", responseDocType.getDocumentMovByidDocumentType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "10-18-" + s + "-E";
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
//            //Xaric olan telefoqnarama
//
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDocType.getDocumentMovByidDocumentType().getIdDocumentType() == 100) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType() :{}", responseDocType.getDocumentMovByidDocumentType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "T-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDep.getDepartment().getIdDep() == 2 &&responseDocType.getDocumentMovByidDocumentType().getIdDocumentType()==151) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType() :{}", responseDocType.getDocumentMovByidDocumentType());
//                String s = "";
//                s += getDocCount(document.getIdDocumentType());
//
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "sobe indeksi-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
//
//            else if (responseApplicant.getApplicant() == null &&
//                    responseDep.getDepartment().getIdDep() == 2 &&responseDocType.getDocumentMovByidDocumentType().getIdDocumentType()==151) {
//                logger.info("responseDocType.getDocumentMovByidDocumentType() :{}", responseDocType.getDocumentMovByidDocumentType());
//                String s = "";
//                String docIDForCode = document.getIdDocument() + "";
//                for (int i = 0; i < 1 - s.length(); i++) {
//                    s += "0";
//
//                }
//                s += docIDForCode;
//                while (s.length() < 5) {
//                    s = "0" + s;
//                }
//                String docCode1 = "sobe indeksi-" + s;
//                document.setDocumentCode(docCode1);
//                logger.info("responseDocType.getDocumentMovByidDocumentType().getType() :{} ", document.toString());
//            }
//
//
//
//
//            //            document=repoDocument.save(document);
//            document = hazelCastUtility.save(document);
//            documentResponse.setDocument(document);
//            logger.info("Doc----hazelCast----documentResponse-- :{}", documentResponse.toString());
//
//            saveDocElastic(document);
//
//            logger.info("step9 docda saveDocElastic : {} ", saveDocElastic(document).toString());
//
//            documentResponse.setServerCode(200);
//            documentResponse.setServerMessage("OK");
//            documentResponse.setStatusMessage("Saved");
//            logger.info("Document response : {}", saveDocumentRequest.toString());
//
//            logger.info("step10");
//
//        } catch (Exception e) {
//            documentResponse.setServerCode(100);
//            documentResponse.setServerMessage("error");
//            documentResponse.setStatusMessage("No Saved");
//            logger.error("Error save file text : {}", e);
//        }
//        return documentResponse;
//    }
//
//    public ResponseDocCount getDocCount(long idDocType) {
//        ResponseDocCount responseDocCount = new ResponseDocCount();
//
//        try {
//            responseDocCount.setDocType(repoDocument.countByIdDocumentType(idDocType));
//
//            responseDocCount.setServerCode(200);
//            responseDocCount.setServerMessage("Doc Count");
//            logger.info("Doc Count idEmpFrom count :{} idEmpTo :{} ", responseDocCount.getDocType());
//
//        } catch (Exception e) {
//            responseDocCount.setServerCode(100);
//            responseDocCount.setServerMessage("error");
//            logger.error("error :", e);
//        }
//        return responseDocCount;
//
//    }
//
//    public DocumentResponse saveDocElastic(Document document) {
//        DocumentResponse documentResponse = new DocumentResponse();
//        try {
//            logger.info("step1");
//
//            ResponseDocInfo docInfo = docInfoProxy.getDocInfo(document.getIdDocument());
//            logger.info("--step2----------docInfo---------- : {}", docInfo.toString());
//
//            RequestDocElastic requestDocElastic = new RequestDocElastic();
//
//            requestDocElastic.setApplicant(docInfo.getApplicant());
//            requestDocElastic.setDocument(docInfo.getDocument());
//
//            logger.info("step3 :{}", requestDocElastic.toString());
//
//            docElasticProxy.saveDocElastic(requestDocElastic);
//
//            logger.info("step4 :{}", requestDocElastic.toString());
//            documentResponse.setServerCode(200);
//            documentResponse.setStatusMessage("Saved");
//
//
//            logger.info("trying to send data to elastic service ");
//
//
//        } catch (Exception e) {
//            documentResponse.setServerCode(100);
//            documentResponse.setServerMessage("error");
//            documentResponse.setStatusMessage("No Saved");
//            logger.error("Error save file text : {}", e);
//        }
//        return documentResponse;
//    }
//
//
////    private long convertDateToDateTime(String date){
////        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
////        try {
////            Date d = f.parse(date);
////            long milliseconds = d.getTime();
////            return milliseconds;
////        } catch (ParseException e) {
////            e.printStackTrace();
////            return 0;
////        }
////    }
//
//
//    public DocumentResponse updateIsMoved(long idDoc) {
//        DocumentResponse documentResponse = new DocumentResponse();
//        Document doc = repoDocument.findByIdDocumentAndIsVisible(idDoc, 1);
//        try {
//            if (doc != null) {
//                documentResponse.setServerCode(200);
//                documentResponse.setServerMessage("OK");
//                documentResponse.setStatusMessage("Update");
//
//                doc.setIsMoved(1);
//                doc = repoDocument.save(doc);
//                documentResponse.setDocument(doc);
//            }
//        } catch (Exception e) {
//            documentResponse.setServerCode(100);
//            documentResponse.setStatusMessage("No Update");
//            documentResponse.setServerMessage("error");
//            logger.error("Error save file text : {}", e);
//        }
//        return documentResponse;
//    }
//
//
//    public DocumentResponse updateDocument(UpdateDocumentRequest updateDocumentRequest) {
//        DocumentResponse documentResponse = new DocumentResponse();
//        Document doc = repoDocument.findByIdDocumentAndIsVisible(updateDocumentRequest.getIdDocument(), 1);
//
//        try {
//            if (doc != null) {
//
//                documentResponse.setServerCode(200);
//                documentResponse.setServerMessage("OK");
//                documentResponse.setStatusMessage("Update");
//                logger.info("updateDocument response : {}", updateDocumentRequest.toString());
//
//                doc.setDocumentCode(updateDocumentRequest.getDocumentCode());
//                doc.setIdDocumentType(updateDocumentRequest.getIdDocumentType());
//                doc.setIdApplicant(updateDocumentRequest.getIdApplicant());
//                doc.setOrganisation(updateDocumentRequest.getOrganisation());
//                doc.setIdDepartment(updateDocumentRequest.getIdDepartment());
//                doc.setNote(updateDocumentRequest.getNote());
//                doc.setIsVisible(1);
//                doc.setIsDelete(0);
//                doc.setIsControl(updateDocumentRequest.getIsControl());
//                doc.setIdCreatedEmp(updateDocumentRequest.getIdCreatedEmp());
//
//                doc.setExpiredDate(updateDocumentRequest.getExpiredDate());
//                doc.setIsMoved(updateDocumentRequest.getIsMoved());
//                doc.setDocumentEnteredDate(updateDocumentRequest.getDocumentEnteredDate());
//                doc.setVereqSayi(updateDocumentRequest.getVereqSayi());
//                doc.setQosma(updateDocumentRequest.getQosma());
//                doc.setQosmaSayi(updateDocumentRequest.getQosmaSayi());
//                doc.setOrgDate(updateDocumentRequest.getOrgDate());
//                doc.setOrgNo(updateDocumentRequest.getOrgNo());
//                doc.setCombineDocument(updateDocumentRequest.getCombineDocument());
//
//                doc.setOrganisation(updateDocumentRequest.getOrganisation());
////                doc=repoDocument.save(doc);
//                doc = hazelCastUtility.save(doc);
//                documentResponse.setDocument(doc);
//            } else {
//                documentResponse.setServerCode(220);
//                documentResponse.setServerMessage("OK");
//                documentResponse.setStatusMessage("file not found");
//                logger.info("updateDocument response : {}", documentResponse.toString());
//            }
//        } catch (Exception e) {
//            documentResponse.setServerCode(100);
//            documentResponse.setServerMessage("error");
//            documentResponse.setStatusMessage("No Update");
//            logger.error("Error save file text : {}", e);
//        }
//        return documentResponse;
//    }
//
//
//    public DocumentResponse deleteIdDocument(DeleteDocumentRequest deleteDocumentRequest) {
//        DocumentResponse documentResponse = new DocumentResponse();
//        try {
//            Document doc = repoDocument.findByIdDocumentAndIsVisible(deleteDocumentRequest.getIdDocument(), 1);
//            if (doc == null) {
//                documentResponse.setServerMessage("OK");
//                documentResponse.setServerCode(220);
//                documentResponse.setStatusMessage("Document not found!!!");
//            } else {
//                if (deleteDocumentRequest.getIdDocument() == deleteDocumentRequest.getEmpId()) {
//                    //icaze verirsenki silmeye
//                    documentResponse.setServerCode(200);
//                    documentResponse.setServerMessage("OK");
//                    documentResponse.setStatusMessage("Deleted");
//                    doc.setIsVisible(0);
//                    repoDocument.save(doc);
//                } else {
//                    //silinmesine icaze yoxdu
//                    documentResponse.setServerCode(220);
//                    documentResponse.setServerMessage("OK");
//                    documentResponse.setStatusMessage("You have not access to delete this document");
//                }
//            }
//        } catch (Exception e) {
//            documentResponse.setServerCode(100);
//            documentResponse.setServerMessage("error");
//            documentResponse.setStatusMessage("Error from server side");
//            logger.error("Error delete : {}", e);
//        }
//        return documentResponse;
//    }
//
//
//}
//
//
