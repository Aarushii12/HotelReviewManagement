# Use an official Python runtime as a parent image
FROM python:3.11-slim

# Set environment variables
ENV ANSIBLE_VERSION 4.0.0

# Install dependencies
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    ssh \
    && rm -rf /var/lib/apt/lists/*

# Install Ansible
RUN pip install ansible==${ANSIBLE_VERSION}

# Display Ansible version
RUN ansible --version

# Set the working directory
WORKDIR /ansible

# Default command
CMD ["ansible-playbook", "--version"]
