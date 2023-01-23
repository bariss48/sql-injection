# sql-injection

####
SQL injection, web uygulamalarındaki güvenlik açıklarından biridir ve veritabanına erişim izni olan kullanıcıların sisteme zararlı bir şekilde müdahale etmelerine olanak tanır.
####

## Bu Zaafiyetin Temel Sebebi Nedir?

#####
Ana nedeni, uygulamaların SQL sorgularını doğru şekilde yürütmemesi ve güvenli hale getirmemesidir. Bu nedenle, sorgulara kullanıcı tarafından girilen veriler doğrudan eklenir ve sisteme zararlı bir şekilde müdahale edilir. Örneğin, bir saldırgan bir login formunda "kullanıcı adı" ve "parola" alanlarına zararlı bir SQL komutu girerek veritabanına erişebilir.
#####

## SQL injection açıklarının çalışmakta olan uygulamadan nasıl tespit edilebilir?

#####
Log analiz: Uygulamanın kayıtlarını inceleyerek, uygulamanın geçmişte hangi SQL sorgularını yürüttüğünü ve hangi hata mesajlarını döndürdüğünü kontrol edebilirsiniz.

Network monitoring: Uygulamanın veritabanına gönderdiği sorguları ve cevabları izleyerek, uygulamanın potansiyel SQL injection açıklarını tespit etmeye çalışılır.
#####

## SQL injection saldırılarını önlemek için hangi yöntemler kullanılır?

#####
Parametrik sorgular: Kullanıcı girdileri direk olarak SQL sorgularına eklenmemelidir. Bunun yerine, kullanıcı girdileri parametre olarak gönderilmelidir. Bu sayede, kullanıcı tarafından girilen veriler sisteme zararlı bir şekilde müdahale edemez.

Kullanıcı girdilerinin doğrulanması: Kullanıcı girdileri, uygun formatta ve aralıkta olduğu kontrol edilmelidir. Bu sayede, kullanıcının girdiği değerlerin sistemi zararlı bir şekilde etkilememesi sağlanır.

Kullanıcı yetkilerinin yönetimi: Kullanıcıların, gerektiğinden daha fazla yetkiye sahip olmaması sağlanmalıdır. Örneğin, sadece okuma yetkisi olan kullanıcıların sadece okuma işlemleri yapması sağlanmalıdır.

Güncel güvenlik yamalarının kullanılması: Kullanılan veritabanı ve uygulama platformlarının güncel güvenlik yamalarını kullanmak, sistemi SQL injection saldırılarına karşı korumanıza yardımcı olacaktır.

Güvenli veri yönetimi: Veritabanındaki verilerin şifrelenmesi, yedeklenmesi ve silinmesi gibi işlemler güvenli bir şekilde yapılmalıdır.
#####


## Java Kodunun Açıklanması

#####
Java'da PreparedStatement sınıfı, SQL sorgularının parametrik hale getirilmesini sağlar. Bu sayede, sorgularda kullanılacak değerler önceden hazırlanır ve sorgunun parçası olarak gönderilir. Bu, SQL injection saldırılarına karşı koruma sağlar çünkü sorgulara kullanıcı tarafından girilen veriler doğrudan eklenmemektedir. Yani zararlı kod SQL sorgusuna bütün olarak eklenemez ve bu şekilde sql koumutu zararlı kodu execute() edemez. etse bile SQL o zararlı kodu bütün bir şekilde okumayacağı için sadece aratılan sorguyu bulamamış olur.
#####
