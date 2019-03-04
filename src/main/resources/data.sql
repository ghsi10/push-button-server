INSERT INTO messages(content,audio) VALUES ('message1',0);
INSERT INTO messages(content,audio) VALUES ('message2',0);
INSERT INTO messages(content,audio) VALUES ('message3',1);

INSERT INTO source_types(type) VALUES ('source1');
INSERT INTO source_types(type) VALUES ('source2');
INSERT INTO source_types(type) VALUES ('source4');

INSERT INTO source_devices(id,message_id,source_type_id,description) VALUES (1,1,2,'description1');
INSERT INTO source_devices(id,message_id,source_type_id,description) VALUES (2,2,1,'description2');

--INSERT INTO phones(phone_number,token,device_name) VALUES ('054','d6N-DEe0AuQ:APA91bGZCEIHXpHaRt2S8ZcM5Q5cAz0WzWUMzpZlZ0AQn6SJmCBwra7rDjW8UfjMxIPVCN4NqZckC1Wur3FcA9_DC4iOdblYPls3LPFm5np80rFMgaxiSk_rahX2RddYDuV4btWD0Oyl','samsung galaxy s8');
--
--INSERT INTO source_to_mobile(source_device_id,phones_token) VALUES (1,'d6N-DEe0AuQ:APA91bGZCEIHXpHaRt2S8ZcM5Q5cAz0WzWUMzpZlZ0AQn6SJmCBwra7rDjW8UfjMxIPVCN4NqZckC1Wur3FcA9_DC4iOdblYPls3LPFm5np80rFMgaxiSk_rahX2RddYDuV4btWD0Oyl');

