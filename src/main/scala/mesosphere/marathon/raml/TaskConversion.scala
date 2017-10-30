package mesosphere.marathon.raml

import mesosphere.marathon.{core, raml}
import core.task
import EnrichedTaskConversion._

object TaskConversion extends DefaultConversions {




  implicit val reservationRamlWrites: Writes[task.Task.Reservation, raml.Reservation] = Writes { res =>
    Reservation(
      volumeIds = res.volumeIds.map(_.toRaml),
      state =
    )
  }

  implicit val taskRamlWrites: Writes[task.Task, raml.Task] = Writes { task =>
    Task(
      taskId = task.taskId.idString,
      reservation = task.rese
    )
  }

}
