package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LessonVO;

public class LessonDAO {
	// 과목 전체 조회
	public void getLessonTotalList() throws Exception {
		String sql = "select *from lesson order by no";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LessonVO lvo = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			System.out.printf("%-10s%-10s%-15s\n", "일련번호", "과목약어", "과목명");

			while (rs.next()) {
				lvo = new LessonVO();
				lvo.setNo(rs.getInt("no"));
				lvo.setL_abbre(rs.getString("l_abbre"));
				lvo.setL_name(rs.getString("l_name"));

				System.out.printf("%-10d%-10s%-15s\n", lvo.getNo(), lvo.getL_abbre(), lvo.getL_name());
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception se) {
			}
		}

	}

	// 과목 등록
	public void setLessonRegiste(LessonVO lvo) {
		String sql = "insert into lesson " + "(no, l_abbre, l_name)" + " values" + "(lesson_seq.nextval, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lvo.getL_abbre());
			pstmt.setString(2, lvo.getL_name());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(lvo.getL_name() + " 과목 등록 완료.");
				System.out.println("과목 등록 성공!!");
			} else {
				System.out.println("과목 등록 실패!!");
			}

		} catch (SQLException e) {
			System.out.println("e = [" + e + "]");
		} catch (Exception e) {
			System.out.println("e = [" + e + "]");
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e2) {
			}
		}

	}

	// 과목 수정
	public void setLessonUpdate(LessonVO lvo) throws Exception {
		String sql = "update lesson set l_abbre=?, l_name=? where no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lvo.getL_abbre());
			pstmt.setString(2, lvo.getL_name());
			pstmt.setInt(3, lvo.getNo());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(lvo.getL_name() + " 과목 수정 완료");
				System.out.println("과목 수정 성공!!");
			} else {
				System.out.println("과목 수정 실패!!");
			}

		} catch (SQLException e) {
			System.out.println("e = [" + e + "]");

		} catch (Exception e) {
			System.out.println("e = [" + e + "]");
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
			}
		}

	}

	// 과목 삭제
	public void setLessonDelete(int no) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from lesson where no = ?");

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println("과목 삭제 완료.");
				System.out.println("과목 삭제 성공!!!");
			} else {
				System.out.println("과목 삭제 실패!!!");

			}

		} catch (SQLException e) {
			System.out.println("e = [" + e + "]");

		} catch (Exception e) {
			System.out.println("e = [" + e + "]");
		}
		finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
			}
		}

	}

}
