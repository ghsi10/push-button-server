INSERT INTO messages(content,audio) VALUES ('message1',0);
INSERT INTO messages(content,audio) VALUES ('message2',0);
INSERT INTO messages(content,audio) VALUES ('message3',1);

INSERT INTO source_types(type) VALUES ('source1');
INSERT INTO source_types(type) VALUES ('source2');
INSERT INTO source_types(type) VALUES ('source4');

INSERT INTO source_devices(id,message_id,source_type_id,description) VALUES (1,1,2,'description1');
INSERT INTO source_devices(id,message_id,source_type_id,description) VALUES (2,2,1,'description2');

INSERT INTO phones(phone_number,token,device_name) VALUES ('054','dBJ4QTxLROk:APA91bF5XZHcXEIA2nVpUW4dyve_8TXjaa7QdlMfZEFZeU30nW1_t2FbQRTGrByVA7RMwuV_7GGtH7LmxN7QmZEZtgCY6bu-_h0ivb9UtuBLd3QT-RdPeMLAjBq0FowyDBzV-CcdgYlC','samsung galaxy s8');

INSERT INTO source_to_mobile(source_device_id,phones_token) VALUES (1,'dBJ4QTxLROk:APA91bF5XZHcXEIA2nVpUW4dyve_8TXjaa7QdlMfZEFZeU30nW1_t2FbQRTGrByVA7RMwuV_7GGtH7LmxN7QmZEZtgCY6bu-_h0ivb9UtuBLd3QT-RdPeMLAjBq0FowyDBzV-CcdgYlC');

