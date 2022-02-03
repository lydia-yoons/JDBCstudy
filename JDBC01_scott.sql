SELECT USER
FROM DUAL;
--==>> SCOTT

DROP TABLE TBL_MEMBER;
--==>> Table TBL_MEMBER��(��) �����Ǿ����ϴ�.

--�� �ǽ� ���̺� ����
CREATE TABLE TBL_MEMBER
( SID   NUMBER
, NAME  VARCHAR2(30)
, TEL   VARCHAR2(60)
, CONSTRAINT MEMBER_SID_PK PRIMARY KEY(SID)
);
--==>> Table TBL_MEMBER��(��) �����Ǿ����ϴ�.


--�� ���� ������ �Է�
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(1, '������', '010-5387-9404');
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

--�� Ȯ��
SELECT *
FROM TBL_MEMBER;
--==>> 1	������	010-5387-9404

--�� Ŀ��
COMMIT;


-- �� �ڹٿ��� Test003Ŭ���� ���� �� �ٽ� Ȯ��
select *
from tbl_member;
--==>>
/*
1	������	010-5387-9404
2	ä����	010-2222-2222
*/

-- �� �ڹٿ��� Test004Ŭ���� ���� �� �ٽ� Ȯ��
SELECT *
FROM TBL_MEMBER;
--==>>
/*
1	������	010-5387-9404
2	ä����	010-2222-2222
3	��ҿ�	010-3333-3333
4	������	010-4444-4444
5	�մ���	010-5555-5555
*/

--�� ������ ��ȸ ������ �غ�
SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;
--> �� �� ����
SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID;





