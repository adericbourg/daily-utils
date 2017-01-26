package net.dericbourg.daily.utils.typesafe

import java.lang.{Boolean, Double, Long}
import java.util

import com.typesafe.config.Config

package object config {

  implicit class ConfigExtension(config: Config) {

    def getAnyRefOption(path: String): Option[AnyRef] = {
      if (config.hasPath(path)) Some(config.getAnyRef(path))
      else None
    }

    def getAnyRefListOption(path: String): Option[util.List[_]] = {
      if (config.hasPath(path)) Some(config.getAnyRefList(path))
      else None
    }

    def getBooleanOption(path: String): Option[Boolean] = {
      if (config.hasPath(path)) Some(config.getBoolean(path))
      else None
    }

    def getBooleanListOption(path: String): Option[util.List[Boolean]] = {
      if (config.hasPath(path)) Some(config.getBooleanList(path))
      else None
    }

    def getBytesOption(path: String): Option[Long] = {
      if (config.hasPath(path)) Some(config.getBytes(path))
      else None
    }

    def getBytesListOption(path: String): Option[util.List[Long]] = {
      if (config.hasPath(path)) Some(config.getBytesList(path))
      else None
    }

    def getConfigOption(path: String): Option[Config] = {
      if (config.hasPath(path)) Some(config.getConfig(path))
      else None
    }

    def getConfigListOption(path: String): Option[util.List[_ <: Config]] = {
      if (config.hasPath(path)) Some(config.getConfigList(path))
      else None
    }

    def getDoubleOption(path: String): Option[Double] = {
      if (config.hasPath(path)) Some(config.getDouble(path))
      else None
    }

    def getDoubleListOption(path: String): Option[util.List[Double]] = {
      if (config.hasPath(path)) Some(config.getDoubleList(path))
      else None
    }

    def getIntOption(path: String): Option[Int] = {
      if (config.hasPath(path)) Some(config.getInt(path))
      else None
    }

    def getIntListOption(path: String): Option[util.List[Integer]] = {
      if (config.hasPath(path)) Some(config.getIntList(path))
      else None
    }

    def getListOption(path: String): Option[ConfigList] = {
      if (config.hasPath(path)) Some(config.getList(path))
      else None
    }

    def getLongOption(path: String): Option[Long] = {
      if (config.hasPath(path)) Some(config.getLong(path))
      else None
    }

    def getLongListOption(path: String): Option[util.List[Long]] = {
      if (config.hasPath(path)) Some(config.getLongList(path))
      else None
    }

    def getMemorySizeOption(path: String): Option[ConfigMemorySize] = {
      if (config.hasPath(path)) Some(config.getMemorySize(path))
      else None
    }

    def getMemorySizeListOption(path: String): Option[util.List[ConfigMemorySize]] = {
      if (config.hasPath(path)) Some(config.getMemorySizeList(path))
      else None
    }

    def getNumberOption(path: String): Option[Number] = {
      if (config.hasPath(path)) Some(config.getNumber(path))
      else None
    }

    def getNumberListOption(path: String): Option[util.List[Number]] = {
      if (config.hasPath(path)) Some(config.getNumberList(path))
      else None
    }

    def getObjectOption(path: String): Option[ConfigObject] = {
      if (config.hasPath(path)) Some(config.getObject(path))
      else None
    }

    def getObjectListOption(path: String): Option[util.List[_ <: ConfigObject]] = {
      if (config.hasPath(path)) Some(config.getObjectList(path))
      else None
    }

    def getStringOption(path: String): Option[String] = {
      if (config.hasPath(path)) Some(config.getString(path))
      else None
    }

    def getStringListOption(path: String): Option[util.List[String]] = {
      if (config.hasPath(path)) Some(config.getStringList(path))
      else None
    }

    def getValueOption(path: String): Option[ConfigValue] = {
      if (config.hasPath(path)) Some(config.getValue(path))
      else None
    }
  }

}
