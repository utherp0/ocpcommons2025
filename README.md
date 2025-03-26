Simple components for VM demo - html and Quarkus source

Useful commands on VM:

sudo mount /dev/vdc /mnt/appdisk (after reboot to restore PVC rather than complex fstab)
sudo cp /home/fedora/git/ocpcommons2025/html/* /var/www/html/ (copy git html into webserver serve point)

cd /home/fedora/git/ocpcommons2025/quarkus/testservices
quarkus run & (run the Quarkus microservices in the background post reboot)
