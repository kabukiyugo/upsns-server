INSERT INTO upload_sns.user
(id, name, furigana, mail, tel_no, password, insert_time, icon_image_path, comment, cognito_id)
VALUES(100, 'TestName', 'TestFurigana', 'TestAddress', 'TestNo', 'TestPass', now(), 'TestImage', 'TestComment', 'Test-Name');

INSERT INTO upload_sns.user
(id, name, furigana, mail, tel_no, password, insert_time, icon_image_path, comment, cognito_id)
VALUES(700, 'TestName1', 'TestFurigana1', 'TestAddress1', 'TestNo1', 'TestPass1', now(), 'TestImage1', 'TestComment1', 'Test-Name1');

INSERT INTO upload_sns.image
(id, image_file_path, insert_time)
VALUES(400, 'TestFile1', now());

INSERT INTO upload_sns.image
(id, image_file_path, insert_time)
VALUES(401, 'TestFile2', now());

INSERT INTO upload_sns.article
(id, title, body, user_id, insert_time, image_id)
VALUES(300,'TestTitle', 'TestBody', 100, '2022-07-31 00:00:00.000', 400);

INSERT INTO upload_sns.article
(id, title, body, user_id, insert_time, image_id)
VALUES(301,'TestTitle1', 'TestBody1', 700, '2022-07-31 00:00:00.000', 401);

INSERT INTO upload_sns.article
(id, title, body, user_id, insert_time)
VALUES(302,'TestTitle2', 'TestBody2', 700, now());

INSERT INTO upload_sns.article
(id, title, body, user_id, insert_time)
VALUES(303,'TestTitle3', 'TestBody3', 700, now());

INSERT INTO upload_sns.article
(id, title, body, user_id, insert_time)
VALUES(304,'TestTitle4', 'TestBody4', 700, now());

INSERT INTO upload_sns.article
(id, title, body, user_id, insert_time)
VALUES(305,'TestTitle5', 'TestBody5', 700, now());

INSERT INTO upload_sns.article
(id, title, body, user_id, insert_time)
VALUES(306,'TestTitle6', 'TestBody6', 700, now());

INSERT INTO upload_sns.article
(id, title, body, user_id, insert_time)
VALUES(307,'TestTitle7', 'TestBody7', 700, now());

INSERT INTO upload_sns.article
(id, title, body, user_id, insert_time)
VALUES(308,'TestTitle8', 'TestBody8', 700, now());

INSERT INTO upload_sns.article
(id, title, body, user_id, insert_time)
VALUES(309,'TestTitle9', 'TestBody9', 700, now());

INSERT INTO upload_sns.article
(id, title, body, user_id, insert_time)
VALUES(310,'TestTitle10', 'TestBody10', 700, now());

INSERT INTO upload_sns.favorite
(id, push_user_id, article_id, insert_time)
VALUES(200, 100, 300, now());

INSERT INTO upload_sns.tag
(id, name, insert_time)
VALUES(500, 'TestName1', now());

INSERT INTO upload_sns.tag
(id, name, insert_time)
VALUES(501, 'TestName2', now());

INSERT INTO upload_sns.article_use_tag
(article_id, tag_id)
VALUES(300, 500);

INSERT INTO upload_sns.article_use_tag
(article_id, tag_id)
VALUES(300, 501);

INSERT INTO upload_sns.reply
(id, comment, user_id, insert_time, article_id)
VALUES(600, 'ParentComment', 100, now(), 302);

INSERT INTO upload_sns.reply
(id, comment, user_id, parent_id, insert_time, article_id)
VALUES(601, 'ChildrenComment', 100, 600, now(), 302);

INSERT INTO upload_sns.reply
(id, comment, user_id, insert_time, article_id)
VALUES(602, 'TestComment', 100, now(), 303);