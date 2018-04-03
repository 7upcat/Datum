
package org.mipha.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mipha.factory.ConnectorFactory;
import org.mipha.olap.domain.Connector;
import org.mipha.olap.domain.ConnectorRepository;
import org.mipha.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class ConnectorRepositoryTest extends BaseTest {

	@Autowired
	private ConnectorRepository connectorRepository;

	private Connector connector = ConnectorFactory.newSampleDBConnector();

	@Before
	public void setup() {
		connectorRepository.save(connector);
	}

	@After
	public void teardown() {
		connectorRepository.delete(connector);
	}

	@Test
	public void find() {
		Assert.assertTrue(connectorRepository.findById(connector.getId()).isPresent());
	}
}
