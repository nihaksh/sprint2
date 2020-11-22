package com.cg.go.greatoutdoor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.go.greatoutdoor.dao.IOrderRepository;
import com.cg.go.greatoutdoor.entity.OrderEntity;
import com.cg.go.greatoutdoor.exception.OrderException;
import com.cg.go.greatoutdoor.service.OrderServiceImpl;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
	
	@Mock
	IOrderRepository OrderRepository;

	@InjectMocks
	OrderServiceImpl service;
	
	@Test
	public void addOrderTest() throws Exception
	{
		OrderEntity order = mock(OrderEntity.class);
		service.addOrder(order);
		verify(OrderRepository).save(order);
	}	
	@Test
	public void findallOrdersTest() throws OrderException
	{
		List<OrderEntity> list = new ArrayList<>();
		OrderEntity s1 = mock(OrderEntity.class);
		OrderEntity s2 = mock(OrderEntity.class);
		OrderEntity s3 = mock(OrderEntity.class);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		when(OrderRepository.findAll()).thenReturn(list);
		List<OrderEntity> actual = service.findAllOrders();
		Assertions.assertEquals(list.size(), actual.size());
		verify(OrderRepository).findAll();
		
		}
}