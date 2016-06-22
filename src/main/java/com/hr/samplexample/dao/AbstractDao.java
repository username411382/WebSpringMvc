package com.hr.samplexample.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**这个泛型抽象类是所有DAO实现类的父类。
 * 它提供了所有hibernate操作的通用方法。请注意上面。
 * 我们在第3步创建的SessionFactory对象将会被Spring容器自动装载。
 * @author ruihe
 * @param <PK>
 * @param <T>
 */
public abstract class AbstractDao <PK extends Serializable,T>{

	private final Class<T> persistentClass;  
    
    @SuppressWarnings("unchecked")  
    public AbstractDao(){  
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];  
    }  
       
    @Autowired  
    private SessionFactory sessionFactory;  
   
    protected Session getSession(){  
        return sessionFactory.getCurrentSession();  
    }  
   
    @SuppressWarnings("unchecked")  
    public T getByKey(PK key) {  
        return (T) getSession().get(persistentClass, key);  
    }  
   
    public void persist(T entity) {  
        getSession().persist(entity);  
    }  
   
    public void delete(T entity) {  
        getSession().delete(entity);  
    }  
       
    protected Criteria createEntityCriteria(){  
        return getSession().createCriteria(persistentClass);  
    }  
	
	
}
