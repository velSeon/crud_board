-- 테스트 계정
-- TODO: 테스트용이지만 비밀번호가 노출된 데이터 세팅. 개선하는 것이 좋을 지 고민해 보자.
insert into user_account (user_id, user_password, nickname, email, memo, created_at, created_by, modified_at, modified_by) values
    ('inseon', '{noop}asdf1234', 'inseon', 'inseon@mail.com', 'I am inseon.', now(), 'inseon', now(), 'inseon')
;
insert into user_account (user_id, user_password, nickname, email, memo, created_at, created_by, modified_at, modified_by) values
    ('inseon2', '{noop}asdf1234', 'inseon2', 'inseon2@mail.com', 'I am inseon2.', now(), 'inseon2', now(), 'inseon2')
;
