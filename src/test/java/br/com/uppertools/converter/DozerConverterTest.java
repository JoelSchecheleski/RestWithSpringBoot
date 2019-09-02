package br.com.uppertools.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.uppertools.converter.mock.MockPerson;
import br.com.uppertools.data.model.Person;
import br.com.uppertools.data.vo.PersonVO;

public class DozerConverterTest {
	
    MockPerson inputObject;

    @Before
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = DozerConverter.parserObject(inputObject.mockEntity(), PersonVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
        Assert.assertEquals("Addres Test0", output.getAdress());
        Assert.assertEquals("Male", output.getGenger());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = DozerConverter.parserListObjects(inputObject.mockEntityList(), PersonVO.class);
        PersonVO outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputZero.getLastName());
        Assert.assertEquals("Addres Test0", outputZero.getAdress());
        Assert.assertEquals("Male", outputZero.getGenger());
        
        PersonVO outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assert.assertEquals("Addres Test7", outputSeven.getAdress());
        Assert.assertEquals("Female", outputSeven.getGenger());
        
        PersonVO outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
        Assert.assertEquals("Addres Test12", outputTwelve.getAdress());
        Assert.assertEquals("Male", outputTwelve.getGenger());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozerConverter.parserObject(inputObject.mockVO(), Person.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
        Assert.assertEquals("Addres Test0", output.getAdress());
        Assert.assertEquals("Male", output.getGenger());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozerConverter.parserListObjects(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputZero.getLastName());
        Assert.assertEquals("Addres Test0", outputZero.getAdress());
        Assert.assertEquals("Male", outputZero.getGenger());
        
        Person outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assert.assertEquals("Addres Test7", outputSeven.getAdress());
        Assert.assertEquals("Female", outputSeven.getGenger());
        
        Person outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
        Assert.assertEquals("Addres Test12", outputTwelve.getAdress());
        Assert.assertEquals("Male", outputTwelve.getGenger());
    }
}
