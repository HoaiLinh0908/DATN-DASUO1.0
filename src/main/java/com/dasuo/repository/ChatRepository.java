package com.dasuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
	@Query(value = "SELECT * FROM dasuo.chat where nguoigui_id=?1 && nguoinhan_id=?2", nativeQuery = true)
	public Chat findChatByGN(Integer idgui, Integer idnhan);

}
