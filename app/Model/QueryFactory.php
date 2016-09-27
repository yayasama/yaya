<?php

namespace app\Model;

use Doctrine\DBAL\DriverManager;
use Doctrine\DBAL\Configuration;
use Config;

trait QueryFactory
{
    protected $queryBuilder;

    /**
     * QueryFactory constructor.
     */
    public function __construct()
    {
        $config = Config::get('database.connections.mysql');
        $connectionParams = [
            'dbname' => $config['database'],
            'user' => $config['username'],
            'password' => $config['password'],
            'host' => $config['host'],
            'port' =>  $config['port'],
            'driver' => 'pdo_mysql',
            'charset' => $config['charset']
        ];
        $configuration = new Configuration();

        $conn = DriverManager::getConnection($connectionParams,$configuration);
        $this->queryBuilder = $conn->createQueryBuilder();
    }
}