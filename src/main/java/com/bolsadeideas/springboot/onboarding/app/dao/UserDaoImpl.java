package com.bolsadeideas.springboot.onboarding.app.dao;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bolsadeideas.springboot.onboarding.app.models.Cliente;
import com.bolsadeideas.springboot.onboarding.app.models.request.UpdateClientTO;

@Repository
public class UserDaoImpl implements UsersDao {

	private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void registerClient(Cliente c) {
		mongoTemplate.insert(c);
	}

	@Override
	public boolean existUsername(String u) {
		Query query = new Query();
		Criteria criterioBusqueda = Criteria.where("username").is(u);
		query.addCriteria(criterioBusqueda);
		return mongoTemplate.exists(query, Cliente.class);

	}

	public void update(UpdateClientTO data) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("idClient");

		Criteria criterioBusqueda = Criteria.where("_id").is(new ObjectId(id));
		Query query = new Query(criterioBusqueda);
		Update update = new Update();
		if (Objects.nonNull(data.getName())) {
			update.set("name", data.getName());
		}
		if (Objects.nonNull(data.getLastName())) {
			update.set("lastName", data.getLastName());
		}
		if (Objects.nonNull(data.getSecondLastName())) {
			update.set("secondLastName", data.getSecondLastName());
		}
		if (Objects.nonNull(data.getDescriptionHouse())) {
			update.set("descriptionHouse", data.getDescriptionHouse());
		}

		mongoTemplate.updateFirst(query, update, Cliente.class);

	}

}
