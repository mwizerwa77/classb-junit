package com.example.classbjunit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;


public class ListMockTest {

	List<String> mockList = mock(List.class);
	
	@Test
	public void size_basic() {
		when(mockList.size()).thenReturn(5);
		assertEquals(5, mockList.size());
	}
	
	@Test
	public void returnDifferentValues() {
		when(mockList.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mockList.size());
		assertEquals(10, mockList.size());
		
	}
	
	@Test
	public void returnParameter() {
		when(mockList.get(0)).thenReturn("Java");
		assertEquals("Java", mockList.get(0));
		assertEquals(null, mockList.get(1));
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(mockList.get(anyInt())).thenReturn("Java");
		assertEquals("Java", mockList.get(0));
		assertEquals("Java", mockList.get(1));
	}
	
	@Test
	public void verificationBasics() {
		String value = mockList.get(0);
		String value2 = mockList.get(1);
		
		//verify
		verify(mockList).get(0);
		verify(mockList).get(anyInt());
		//verify(mockList, times(1)).get(anyInt());
		verify(mockList, times(2)).get(anyInt());
		verify(mockList,atLeast(1)).get(anyInt());
		verify(mockList,atMost(2)).get(anyInt());
		verify(mockList,never()).get(2);
		
	}
	
	@Test
	public void argumentCapturing() {
		mockList.add("Mydata");
		
		//verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mockList).add(captor.capture());
		
		assertEquals("Mydata", captor.getValue());
	}
	
	@Test
	public void multipleArgumentCapturing() {
		mockList.add("Save1");
		mockList.add("Save2");
		
		//verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		//by default verify(mock) checks if value is called once
		//verify(mock).add(captor.capture());//this fails
		
		verify(mockList, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		assertEquals("Save1", allValues.get(0));
		assertEquals("Save2", allValues.get(1));
	}
	
	@Test
	public void mocking() {

		//mock does not retain original behaviour of the code
		ArrayList<String> arrayListMock =  mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());//0
		
		when(arrayListMock.size())
		.thenReturn(5);
		when(arrayListMock.get(0)).thenReturn("Svd");
		
		System.out.println(arrayListMock.size());//5
		assertEquals("Svd", arrayListMock.get(0));
		
	}
	
	@Test
	public void spying() {

		//spying retains original behaviour of the code
		ArrayList<String> arrayListSpy =  spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));//Test0
		System.out.println(arrayListSpy.size());//1
		
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());//3
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5
		//now call is lost so 5 will be returned no matter what
	
		arrayListSpy.add("Test3");
		System.out.println(arrayListSpy.size());//5
		
		//verify(arrayListSpy).add("Test4");
	}
}
