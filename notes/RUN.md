# How to Run

1. First, start the postgres server.
  `sudo pg_ctlcluster 12 main root`
2. Check the status of postgres server using
  `service postgresql status`
3. Get into admin of the machine and login to postgresql
  `sudo su` && `sudo -u postgres psql`