package mesosphere.marathon.raml

import mesosphere.marathon.{core, raml}
import core.instance

object InstanceConversion extends HealthConversion with DefaultConversions with OfferConversion {

  implicit val agentInfoRamlWrites: Writes[instance.Instance.AgentInfo, raml.AgentInfo] = Writes { ai =>
    AgentInfo(
      ai.host,
      ai.agentId,
      ai.region,
      ai.zone,
      ai.attributes.map(_.toRaml)
    )
  }

  implicit val instanceRamlWrites: Writes[instance.Instance, raml.Instance] = Writes { i =>
    Instance(
      instanceId = i.instanceId.idString,
      agentInfo = i.agentInfo.toRaml,
      taskMap = i.tasksMap.map{case (taskId, task) => taskId.idString -> task.toRaml}
    )

  }

}
